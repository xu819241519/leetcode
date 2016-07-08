package com.ladon.main;

import com.landon.leetcode.LongestPalindromicSubString;
import com.landon.leetcode.Median2SortedArrays;
import com.landon.leetcode.ZigZagConversion;

public class Main {

	public static void main(String[] args) {
//		Median2SortedArrays median2SortedArrays = new Median2SortedArrays();
//		int [] nums1 = {1,3};
//		int [] nums2 = {2};
//		System.out.println("result£º" + median2SortedArrays.findMedianSortedArrays(nums1,nums2));

//		LongestPalindromicSubString subString = new LongestPalindromicSubString();
//		System.out.println(subString.longestPalindrome("b"));
		
		ZigZagConversion conversion = new ZigZagConversion();
		System.out.println(conversion.convert("PAYPALISHIRING", 4));
	}

}
