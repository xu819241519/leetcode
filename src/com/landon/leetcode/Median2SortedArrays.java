package com.landon.leetcode;

import java.util.Locale.LanguageRange;

/**
 * 4.两个有序数组的中位数
 * @author landon.xu
 *
 */
public class Median2SortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		int[] num = mergeSort(nums1, nums2);

		// 开始取中位数

		// 个数为偶数个
		if ((nums1.length + nums2.length) % 2 == 0) {
			result = num[num.length / 2] + num[num.length / 2 - 1];
			result /= 2.0;
		}
		// 个数为奇数个
		else {
			result = num[num.length / 2];
		}
		return result;
	}

	// 归并排序
	private int[] mergeSort(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length + nums2.length];
		// result索引
		int index = 0;
		// nums1索引
		int index1 = 0;
		// nums2索引
		int index2 = 0;

		while (index < result.length) {
			if (index1 >= nums1.length) {
				while (index2 < nums2.length) {
					result[index++] = nums2[index2++];
				}
			}
			if (index2 >= nums2.length) {
				while (index1 < nums1.length) {
					result[index++] = nums1[index1++];
				}
			}
			while (index1 < nums1.length && index2 < nums2.length) {
				if (nums1[index1] <= nums2[index2]) {
					result[index++] = nums1[index1++];
				} else {
					result[index++] = nums2[index2++];
				}
			}
		}
		return result;
	}
	
	//方法二：
	//只排序一半的数据就行
	public double mergeResult(int [] nums1, int [] nums2){
		double result = 0;
		int length = nums1.length  + nums2.length;
		int[] nums = new int[length];
		// result索引
		int index = 0;
		// nums1索引
		int index1 = 0;
		// nums2索引
		int index2 = 0;

		while (index <= nums.length / 2) {
			if (index1 >= nums1.length) {
				if (index2 < nums2.length) {
					nums[index++] = nums2[index2++];
				}
			}
			if (index2 >= nums2.length) {
				if (index1 < nums1.length) {
					nums[index++] = nums1[index1++];
				}
			}
			if (index1 < nums1.length && index2 < nums2.length) {
				if (nums1[index1] <= nums2[index2]) {
					nums[index++] = nums1[index1++];
				} else {
					nums[index++] = nums2[index2++];
				}
			}
		}
		
		if(length % 2 == 0 ){
			result = nums[length / 2] + nums[length / 2 - 1];
			result /= 2.0;
		}
		else{
			result = nums[length / 2];
		}
		return result;
	}
}
