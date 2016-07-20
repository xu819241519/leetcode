package com.landon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.kerberos.KerberosKey;
import javax.xml.crypto.Data;

/**
 * 2sum,3sum closest,4sum
 * 
 * @author landon.xu
 *
 */
public class KSum {


	/**
	 * 3sum closest
	 * @param nums
	 * @param k
	 * @param target
	 * @return
	 */
	public int ThreeSumClosest(int[] nums, int k, int target) {
		k = 3;
		// 升序排列
		Arrays.sort(nums);
		//标记是否比目标值小
		boolean lessThanTarget = false;
		//标记与目标值的差的绝对值
		int delta = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; ++i) {
			// 去重（一部分）
			if (i > 0) {
				int last = i - 1;
				while (i < nums.length && nums[last] == nums[i])
					i++;
				if (i >= nums.length)
					break;
			}

			int m = i + 1;
			int n = nums.length - 1;
			while (m < n) {
				int sum = nums[i] + nums[m] + nums[n];
				int tmpDelta =  Math.abs(sum - target);
				if(tmpDelta < delta){
					delta = tmpDelta;
					if(sum > target)
						lessThanTarget = false;
					else lessThanTarget = true;
					
				}
				if (sum > target) {
					n--;
				} else if (sum < target) {
					m++;
				}
				// 找到一个相等的
				else {
					return target;
				}

			}

		}

		return lessThanTarget ? (target - delta) : ( target + delta);
	}

	/**
	 * 通过递归，解决ksum问题
	 * 
	 * @param nums
	 *            要输入的数组
	 * @param k
	 *            ksum中的k的值
	 * @param target
	 *            要取的目标和值
	 * @param startPos
	 *            起始位置，从此处往后都可以取，往前的数据已经取到了
	 * @param result
	 *            最终要返回的结果
	 * @param item
	 *            某一次测试的list
	 * @param sum
	 *            取到此处当前的和值
	 */
	public void KSum(int nums[], int k, int target, int startPos, List<List<Integer>> result, List<Integer> item,
			int sum) {
		//对于2sum，排好序后，通过首位两个指针来回移动来寻找与target相等的目标
		if (k == 2) {
			if (startPos > nums.length - 2)
				return;
			int m = startPos;
			int n = nums.length - 1;
			while (m < n) {
				if (sum + nums[m] + nums[n] > target) {
					n--;
				} else if (sum + nums[m] + nums[n] < target) {
					m++;
				}
				// 找到一个相等的
				else {
					List<Integer> tmp = new ArrayList<>();
					for (int i = 0; i < item.size(); ++i) {
						tmp.add(item.get(i));
					}
					tmp.add(nums[m]);
					tmp.add(nums[n]);
					result.add(tmp);
					// 去重
					while (++m < n && nums[m - 1] == nums[m])
						;
					while (--n > m && nums[n] == nums[n + 1])
						;
				}
			}
		} else if (k > 2) {
			boolean isFirst = true;
			for (int i = startPos; i < nums.length; ++i) {
				if (!isFirst) {
					int last = i - 1;
					while (i < nums.length && nums[last] == nums[i]) {
						i++;
					}
					if (i >= nums.length)
						break;
				}
				isFirst = false;
				if (item == null)
					item = new ArrayList<>();
				item.add(nums[i]);
				KSum(nums, k - 1, target, i + 1, result, item, sum + nums[i]);
				item.remove(item.lastIndexOf(nums[i]));
			}
		}
	}

	// 通过递归解决通用的ksum问题
	public List<List<Integer>> KSumRecursion() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> data = new ArrayList<>();
		Arrays.sort(nums);
		KSum(nums, 3, 0, 0, data, null, 0);
		return data;
	}

}
