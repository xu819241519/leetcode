package com.landon.leetcode;

/**
 * 9��Palindrome Number���������ö���Ĵ洢�ռ�����ˣ�����Ϊ�������κζ���Ŀռ䣬��ʵ�ǲ����ö���������ȡ�����ı�����
 * 
 * ˼·���Ǻ�ƽ����int����
 * @author landon
 *
 */
public class PalindromeNumber {
	

	public boolean isPalindrome(int x) {
        int y = x;
        int z = 0;
        while(y > 0){
            z *= 10;
            z += y % 10;
            y /= 10;
        }
        return x == z;
    }
}
