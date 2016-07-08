package com.landon.leetcode;

import java.math.BigInteger;

/**
 * 8��String to integer����Ҫ��Ҫ���ȣ���long����������double��BigInteger��������ã�������leetcode��java�汾�ܵͣ�û��������������
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
			//ע������������׸��������ֵ��ַ�����ʱ����Ҫ�ж��ж�
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
