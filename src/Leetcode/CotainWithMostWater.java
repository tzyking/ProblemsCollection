package Leetcode;

/*
 * contain with most water
 * 
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
 */

public class CotainWithMostWater {

	public static int[] MaxArea(int[] heights)
	{
		int i = 0; 
		int j = heights.length - 1; 
		int ret = 0;
		int iFix = 0, jFix = 0; 
		while (i < j)
		{
			int area = (j - i) * Math.min(heights[i], heights[j]);
			if(ret < area)
			{
				iFix = i;
				jFix = j; 
				ret = area;
			}
			if(heights[i] <= heights[j])
				i++; 
			else
				j--;
		}
		
		int[] results = new int[2];
		results[0] = iFix;
		results[1] = jFix;
		return results;
		
	}
	
	
	public static void main(String[] args) {
		int[] input = {4, 3, 5, 1, 6, 2, 7};
		int[] results = MaxArea(input);
		System.out.println(results[0]);
		System.out.println(results[1]);

	}

}
