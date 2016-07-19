package com.landon.leetcode;

/**
 * 11. Container With Most Water Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai). n vertical lines are
 * drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find
 * two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author landon
 *
 */
public class ContainerWithMostWater {

	/**
	 * 主要是根据网上的分析，http://blog.csdn.net/ljiabin/article/details/41673753
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {

		int length = height.length;
		int i = 0, j = length - 1;
		int max = 0;
		if (length > 0) {
			max = j * Math.min(height[i], height[j]);
		}else{
			return 0;
		}
		
		while (i < j) {
			int area = (j - i) * Math.min(height[i], height[j]);
			if(max < area){
				max = area;
			}
			if(height[i] < height[j]){
				i ++ ;
			}else{
				j --;
			}
		}
		
		return max;

	}

}
