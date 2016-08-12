package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses Given n pairs of parentheses, write a function to
 * generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n){
		List<String> result = new ArrayList<>();
		DFS(result, n, 0, n, n, "");
		return result;
	}
	
	/**
	 * 递归实现，除了起始位置，其他任意位置，左括号的数量都是小于等于右括号的数量。所以每次递归的时候，分成两种情况：
	 * 1、当剩余可用的左括号数量等于右括号数量的时候，此位置只能放左括号
	 * 2、当剩余可用的做扩好数量小于右括号数量的时候，此位置可以放左括号，也可以放右括号
	 * @param result	结果
	 * @param n	给定的括号对数
	 * @param depth	遍历深度
	 * @param left	剩余左括号数量
	 * @param right	剩余右括号数量
	 * @param curString	当前拼出的字符串
	 */
	public void DFS(List<String> result, int n, int depth, int left, int right, String curString){
		if(depth == 2 * n){
			if(left == 0 && right == 0){
				result.add(curString);
			}
			return;
		}
		
		if(left == right){
			DFS(result, n, depth + 1, left - 1, right, curString + "(");
		}else if(left < right){
			if(left > 0)
				DFS(result, n, depth + 1, left - 1, right, curString + "(");
			DFS(result, n, depth + 1, left, right - 1, curString + ")");
		}
	}
}
