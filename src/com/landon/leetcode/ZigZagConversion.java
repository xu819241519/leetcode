package com.landon.leetcode;

/**
 * 6��zigzag conversion
 * ͨ��ģ��֮���ε�������̣�����numRows���ַ�����Ȼ���ַ����ϲ����
 * @author landon.xu
 *
 */
public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (s == null || numRows == 0 || numRows == 1)
			return s;
		if (s.equals(""))
			return "";
		int length = s.length();
		String result = "";
		String [] strs = new String[numRows];
		for(int i = 0;i < strs.length; ++i){
			strs[i] = "";
		}
		int index = 0;
		while(index < length){
			for(int i = 0; i < numRows && index < length; ++i){
				strs[i] += s.charAt(index);
				index ++;
			}
			for(int i = numRows - 2; i > 0 && index < length; --i){
				strs[i] += s.charAt(index);
				index ++;
			}
		}
		for(int i = 0; i < numRows; ++i){
			result += strs[i];
		}
		return result;
	}
}
