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
	 * �ݹ�ʵ�֣�������ʼλ�ã���������λ�ã������ŵ���������С�ڵ��������ŵ�����������ÿ�εݹ��ʱ�򣬷ֳ����������
	 * 1����ʣ����õ���������������������������ʱ�򣬴�λ��ֻ�ܷ�������
	 * 2����ʣ����õ�����������С��������������ʱ�򣬴�λ�ÿ��Է������ţ�Ҳ���Է�������
	 * @param result	���
	 * @param n	���������Ŷ���
	 * @param depth	�������
	 * @param left	ʣ������������
	 * @param right	ʣ������������
	 * @param curString	��ǰƴ�����ַ���
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
