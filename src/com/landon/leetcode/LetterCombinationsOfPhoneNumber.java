package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number Given a digit string, return all
 * possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * @author landon
 *
 */
public class LetterCombinationsOfPhoneNumber {

	private String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		letterRecursion(digits, 0, null, result);
		return result;
	}

	/**
	 * 当用循环不好实现时，递归进行遍历
	 * 
	 * @param digits
	 *            输入的字符串
	 * @param index
	 *            已经处理到第几个字符
	 * @param item
	 *            处理到此时已经添加的字符
	 * @param result
	 *            结果
	 */
	private void letterRecursion(String digits, int index, String item, List<String> result) {
		if (index >= digits.length()) {
			if (item != null && item.length() > 0)
				result.add(item.toString());
			return;
		}
		char numC = digits.charAt(index);
		for (int i = 0; i < letters[numC - '0' - 2].length(); ++i) {
			if (item == null) {
				item = new String();
			}
			// 注意这里，每次往下传递时，不能用item，必须new一个新的字符串往后传递，否则后面的都会修改此字符串，为了添加给result中不同的字符串，此次必须new一个新的
			StringBuilder builder = new StringBuilder(item);
			builder.append(letters[numC - '0' - 2].charAt(i));
			letterRecursion(digits, index + 1, builder.toString(), result);
		}
	}
}
