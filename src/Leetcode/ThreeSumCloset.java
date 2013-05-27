/*
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one solution.

 * For example, given array S = {-1 2 1 -4}, and target = 1.

 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * */
package Leetcode;

import java.util.Arrays;

public class ThreeSumCloset {

	public static int[] GetThreeSumCloset(int[] nums, int target)
	{
		int[] ret = new int[3];
		if(nums.length < 3) return ret;
		int sum;
		int diff = Integer.MAX_VALUE;
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++)
		{
			int k = i + 1; 
			int j = nums.length - 1; 
			
			while(k < j)
			{
				sum = nums[i] + nums[k] + nums[j];
				if(Math.abs(sum - target) < diff)
				{
					ret[0] = nums[i]; 
					ret[1] = nums[k];
					ret[2] = nums[j];
					diff = Math.abs(sum - target);
				}
				
				if(sum == target)
				{
					return ret;
				}
				else if(sum < target)
					k++;
				else
					j--;
			}
		}
		return ret;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test_nums = {-1, 2, 1, -4};
		int[] ret = GetThreeSumCloset(test_nums, 1);
		System.out.println(ret[0]);
		System.out.println(ret[1]);
		System.out.println(ret[2]);
	}

}
