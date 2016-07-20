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
		// ��������
		Arrays.sort(nums);
		//����Ƿ��Ŀ��ֵС
		boolean lessThanTarget = false;
		//�����Ŀ��ֵ�Ĳ�ľ���ֵ
		int delta = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; ++i) {
			// ȥ�أ�һ���֣�
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
				// �ҵ�һ����ȵ�
				else {
					return target;
				}

			}

		}

		return lessThanTarget ? (target - delta) : ( target + delta);
	}

	/**
	 * ͨ���ݹ飬���ksum����
	 * 
	 * @param nums
	 *            Ҫ���������
	 * @param k
	 *            ksum�е�k��ֵ
	 * @param target
	 *            Ҫȡ��Ŀ���ֵ
	 * @param startPos
	 *            ��ʼλ�ã��Ӵ˴����󶼿���ȡ����ǰ�������Ѿ�ȡ����
	 * @param result
	 *            ����Ҫ���صĽ��
	 * @param item
	 *            ĳһ�β��Ե�list
	 * @param sum
	 *            ȡ���˴���ǰ�ĺ�ֵ
	 */
	public void KSum(int nums[], int k, int target, int startPos, List<List<Integer>> result, List<Integer> item,
			int sum) {
		//����2sum���ź����ͨ����λ����ָ�������ƶ���Ѱ����target��ȵ�Ŀ��
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
				// �ҵ�һ����ȵ�
				else {
					List<Integer> tmp = new ArrayList<>();
					for (int i = 0; i < item.size(); ++i) {
						tmp.add(item.get(i));
					}
					tmp.add(nums[m]);
					tmp.add(nums[n]);
					result.add(tmp);
					// ȥ��
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

	// ͨ���ݹ���ͨ�õ�ksum����
	public List<List<Integer>> KSumRecursion() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> data = new ArrayList<>();
		Arrays.sort(nums);
		KSum(nums, 3, 0, 0, data, null, 0);
		return data;
	}

}
