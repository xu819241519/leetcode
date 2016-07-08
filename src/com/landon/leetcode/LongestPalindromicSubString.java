package com.landon.leetcode;

import org.ietf.jgss.GSSManager;

/**
 * 5、最长回文子序列
 * 
 * @author landon.xu
 *
 */
public class LongestPalindromicSubString {

	public String longestPalindrome(String s) {
		return DynAlgorithm(s);
	}

	/**
	 * 普通算法，以某个字符或者字符与字符中间为中心点，向左向右扫描回文，长度为n的字符串可以作为中心点的地方有2n-1个
	 * 
	 * @param s 给定的字符串
	 * @return 结果
	 */
	private String generalAlgorithm(String s) {
		if (s == null)
			return null;
		String result = null;
		// 字符串的长度
		int length = s.length();
		// 最大子字符串的长度
		int maxSubLength = 1;
		// 2n-1个中心点位置
		for (int i = 0; i < 2 * length - 1; ++i) {
			int left = i / 2;
			int right = i / 2 + i % 2;

			String tmp = getPalindromicSubString(s, left, right);
			if ((result == null) || (result != null && tmp != null && tmp.length() > result.length()))
				result = tmp;
		}

		return result;
	}

	/**
	 * 在字符串中向左向右扫描，查找回文子字符串
	 * 
	 * @param s
	 *            给定的字符串
	 * @param left
	 *            左边扫描起始点
	 * @param right
	 *            右边扫描起始点
	 * @return 回文子字符串
	 */
	private String getPalindromicSubString(String s, int left, int right) {
		if (s == null)
			return null;
		String result = null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		// 只有一个元素的情况下，需要取到那一个元素
		if (left == right || left + 1 == right)
			result = s.substring(left, left + 1);
		else
			result = s.substring(left + 1, right);
		return result;
	}

	/**
	 * 动态规划
	 * 
	 * @param s 给定的字符串
	 * @return 结果
	 */
	private String DynAlgorithm(String s) {
		if(s == null)
			return null;
		String result = s.substring(s.length() - 1);
		//字符串长度
		int length = s.length();
		//isPalin[i][j] 为true的时候，表示从i到j是回文，否则不是
		boolean [][] isPalin = new boolean[length][length];
		//最长子回文字符串的长度
		int maxSubString = 1;
		
		for(int i = length - 1;i >= 0; -- i){
			for(int j = i; j < length; ++j){
				if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || isPalin[i + 1][j - 1])){
					isPalin[i][j] = true;
					if(maxSubString < j-i + 1){
						maxSubString = j - i + 1;
						result = s.substring(i,j + 1);
					}
				}
			}
		}
		return result;
	}
}
