package com.landon.leetcode;

public class LIS_673 {

	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		//记录最长递增子序列的长度
		int[] longest = new int[nums.length];
		//记录达到最长递增子序列的个数
		int[] count = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			longest[i] = 1;
			count[i] = 1;
		}
		for (int i = 1; i < nums.length; ++i) {
			//当前最大长度的个数
			int c = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					//当有新的最大长度时，更新最大长度的个数
					if (longest[j] + 1 > longest[i]) {
						longest[i] = longest[j] + 1;
						c = count[j];
					} 
					//当再次出现相同的最大长度时，说明有新的路径可以构造最大长度，所以需要加到c中
					else if (longest[j] + 1 == longest[i]) {
						c += count[j];
					}
				}
			}
			count[i] = c;
		}
		int max = Integer.MIN_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (longest[i] > max) {
				max = longest[i];
				result = count[i];
			} else if (longest[i] == max) {
				result += count[i];
			}
		}
		return result;
	}
}
