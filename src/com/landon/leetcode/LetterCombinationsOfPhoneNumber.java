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
	 * ����ѭ������ʵ��ʱ���ݹ���б���
	 * 
	 * @param digits
	 *            ������ַ���
	 * @param index
	 *            �Ѿ������ڼ����ַ�
	 * @param item
	 *            ������ʱ�Ѿ���ӵ��ַ�
	 * @param result
	 *            ���
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
			// ע�����ÿ�����´���ʱ��������item������newһ���µ��ַ������󴫵ݣ��������Ķ����޸Ĵ��ַ�����Ϊ����Ӹ�result�в�ͬ���ַ������˴α���newһ���µ�
			StringBuilder builder = new StringBuilder(item);
			builder.append(letters[numC - '0' - 2].charAt(i));
			letterRecursion(digits, index + 1, builder.toString(), result);
		}
	}
}
