package com.landon.leetcode;

import org.ietf.jgss.GSSManager;

/**
 * 5�������������
 * 
 * @author landon.xu
 *
 */
public class LongestPalindromicSubString {

	public String longestPalindrome(String s) {
		return DynAlgorithm(s);
	}

	/**
	 * ��ͨ�㷨����ĳ���ַ������ַ����ַ��м�Ϊ���ĵ㣬��������ɨ����ģ�����Ϊn���ַ���������Ϊ���ĵ�ĵط���2n-1��
	 * 
	 * @param s �������ַ���
	 * @return ���
	 */
	private String generalAlgorithm(String s) {
		if (s == null)
			return null;
		String result = null;
		// �ַ����ĳ���
		int length = s.length();
		// ������ַ����ĳ���
		int maxSubLength = 1;
		// 2n-1�����ĵ�λ��
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
	 * ���ַ�������������ɨ�裬���һ������ַ���
	 * 
	 * @param s
	 *            �������ַ���
	 * @param left
	 *            ���ɨ����ʼ��
	 * @param right
	 *            �ұ�ɨ����ʼ��
	 * @return �������ַ���
	 */
	private String getPalindromicSubString(String s, int left, int right) {
		if (s == null)
			return null;
		String result = null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		// ֻ��һ��Ԫ�ص�����£���Ҫȡ����һ��Ԫ��
		if (left == right || left + 1 == right)
			result = s.substring(left, left + 1);
		else
			result = s.substring(left + 1, right);
		return result;
	}

	/**
	 * ��̬�滮
	 * 
	 * @param s �������ַ���
	 * @return ���
	 */
	private String DynAlgorithm(String s) {
		if(s == null)
			return null;
		String result = s.substring(s.length() - 1);
		//�ַ�������
		int length = s.length();
		//isPalin[i][j] Ϊtrue��ʱ�򣬱�ʾ��i��j�ǻ��ģ�������
		boolean [][] isPalin = new boolean[length][length];
		//��ӻ����ַ����ĳ���
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
