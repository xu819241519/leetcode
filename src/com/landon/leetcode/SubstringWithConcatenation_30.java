package com.landon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenation_30 {

	private List<Integer> mResult = new ArrayList<Integer>();

	public List<Integer> findSubstring(String s, String[] words) {
		int index = s.indexOf(words[0]);
		while (index != -1) {
			List<String> wordList = new ArrayList<String>();
			for (int i = 1; i < words.length; ++i) {
				wordList.add(words[i]);
			}
			findRecursion(s, wordList, index, index, index, index);
			index = s.indexOf(words[0], index + 1);
		}
		return mResult;
	}

	private void findRecursion(String s, List<String> matchWords, int index, int left, int right, int curLeft) {
		System.out.println(System.currentTimeMillis());
		// 找到结果
		if (matchWords.size() == 0) {
			if (!mResult.contains(curLeft)) {
				mResult.add(curLeft);
			}
			return ;
		}
		// 初次进入
		if (left == right && left == index) {
			int length = matchWords.get(0).length();
			left = index - length;
			right = index + length;
		}
		// 找不到结果
		if ((left < 0 || left >= 0 && !matchWords.contains(s.substring(left, left + matchWords.get(0).length())))
				&& (right + matchWords.get(0).length() > s.length() || right + matchWords.get(0).length() <= s.length()
						&& !matchWords.contains(s.substring(right, right + matchWords.get(0).length())))) {
			return;
		}
		int length = s.length();
		int subLength = matchWords.get(0).length();
		// 往左找
		if (left >= 0) {
			String lString = s.substring(left, left + subLength);
			if (matchWords.contains(lString)) {
				int temp = curLeft;
				curLeft = left;
				matchWords.remove(lString);
				findRecursion(s, matchWords, index, left - subLength, right, curLeft);
				matchWords.add(lString);
				curLeft = temp;
			}
		}
		// 往右找
		if (right + subLength <= length) {
			String rString = s.substring(right, right + subLength);
			if (matchWords.contains(rString)) {
				matchWords.remove(rString);
				findRecursion(s, matchWords, index, left, right + subLength, curLeft);
				matchWords.add(rString);
			}
		}
	}
}
