package com.landon.leetcode;

/**
 * 12. Integer to Roman
 * Given an integer, convert it to a roman numeral.

 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * 
 * 13. Roman to Integer
 * Given a roman numeral, convert it to an integer.

 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author landon.xu
 *
 */
public class IntegerAndRoman {

	/**
	 * int转罗马数字
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		String[][] roman = { 
				{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, 
				{ "", "M", "MM", "MMM" } };
		int digit = 0;
		String result = "";
		while(num != 0){
			int remain = num % 10;
			result = roman[digit++][remain] + result;
			num /= 10;
		}
		return result;

	}
	
	/**
	 * 罗马数字转int
	 * @param s
	 * @return
	 */
	public int romanToInt(String s){
		int result = 0;
		for(int i = 0; i < s.length(); ++i){
			if(i > 0 && getNum(s.charAt(i)) > getNum(s.charAt(i - 1))){
				result += getNum(s.charAt(i)) - 2 * getNum(s.charAt(i - 1));
			}else{
				result += getNum(s.charAt(i));
			}
		}
		return result;
	}
	
	private int getNum(char c){
 		int result = 0;
		switch (c) {
		case 'I':
			result = 1;
			break;
		case 'V':
			result = 5;
			break;
		case 'X':
			result = 10;
			break;
		case 'L':
			result = 50;
			break;
		case 'C':
			result = 100;
			break;
		case 'D':
			result = 500;
			break;
		case 'M':
			result = 1000;
			break;
		default:
			break;
		}
		return result;
	}

}
