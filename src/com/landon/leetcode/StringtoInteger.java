package com.landon.leetcode;

import java.math.BigInteger;

/**
 * 8、String to integer，主要主要精度，用long不够，得用double。BigInteger这个不能用，估计是leetcode的java版本很低，没有这个，编译错误
 * @author landon
 *
 */
public class StringtoInteger {

	public int myAtoi(String str) {
		double result = 0;
		if(str == null || str.length() == 0)
			return 0;
		int flag = 1;
		str = str.trim();
		int index = 0;
		if(str.charAt(0) == '-'){
			flag = -1;
			index ++;
		}else if(str.charAt(0) == '+'){
			index ++;
		}
		int length = str.length();
		while(index < length){
			if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
				result = result * 10 + str.charAt(index) - '0';
			}
			//注意这里，当遇到首个不是数字的字符串的时候，需要中断判断
			else {
				break;
			}
			index ++;
		}

		if(flag == -1)
			result *= -1;
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
        return (int)result;
    }
}
