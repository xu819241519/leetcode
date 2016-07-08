package com.landon.leetcode;

/**
 * 9、Palindrome Number，被不适用额外的存储空间给坑了，还以为不适用任何额外的空间，其实是不适用额外的数组获取其他的变量。
 * 
 * 思路就是很平常的int倒置
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
