package com.landon.leetcode;

/**
 * 7、Reverse Integer，主要主要溢出，其他的没有啥可以说的
 * @author landon
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;		
			x /= 10;
		}

		return (int)result;
	}
}
