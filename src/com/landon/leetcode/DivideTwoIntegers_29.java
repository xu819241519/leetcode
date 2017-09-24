package com.landon.leetcode;

public class DivideTwoIntegers_29 {
	
	public int divideTimeLimition(int dividend, int divisor) {
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		int result = 0;
		if(dividend < 0) {
			if(divisor > 0) {
				while(dividend < 0) {
					dividend += divisor;
					result --;
				}
				if(dividend > 0) {
					result ++;
				}
				return result;		
			}else  {
				while(dividend < 0) {
					dividend -= divisor;
					result ++;
				}
				if(dividend > 0) {
					result --;
				}
				return result;
			}
		}else if(dividend > 0) {
			if(divisor > 0) {
				while(dividend > 0) {
					dividend -= divisor;
					result ++;
				}
				if(dividend < 0) {
					result --;
				}
				return result;
			}else {
				while(dividend > 0) {
					dividend += divisor;
					result --;
				}
				if(dividend < 0) {
					result ++;
				}
				return result;
			}
		}else {
			return 0;
		}
	}
	
	public int divide(int dividend, int divisor) {
		if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean positive = !((dividend < 0) ^ (divisor < 0));
		long dvd = dividend;
		dvd = Math.abs(dvd);
		long dvs = divisor;
		dvs = Math.abs(dvs);
		int result = 0;
		while(dvd >= dvs) {
			long temp = dvs;
			long multiply = 1;
			while(dvd >= (temp << 1)) {
				temp <<= 1;
				multiply <<= 1;
			}
			dvd -= temp;
			result += multiply;
		}
		return positive ? result : -result;
	}
}
