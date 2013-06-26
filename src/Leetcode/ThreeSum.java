package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/* 3 sum: 
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 *	Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ² b ² c)
 *	The solution set must not contain duplicate triplets.
 *  For example, given array S = {-1 0 1 2 -1 -4},
 *
 *  A solution set is:
 *  (-1, 0, 1)
 *  (-1, -1, 2)
 *
 *
 *	Idea:  o(n^2) solution exists. First sort the array, and then from left to right, 
 *	for each num[i], search the pair that sums up to -num[i] using Two Sum algorithm. 
 * */

public class ThreeSum {
	
	 public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 Arrays.sort(num);
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> (); 
	        for(int i = 0; i < num.length - 2; i++) {
	            if (i > 0 && num[i] == num[i - 1])
	                continue; 
	            int j = i + 1; 
	            int k = num.length - 1; 
	            while(j < k) {
	                if(j > i+1 && num[j] == num[j-1]){
	                    j++;
	                    continue;   
	                } 
	                if(k < num.length-1 && num[k] == num[k+1]) {
	                    k--;
	                    continue;    
	                }
	                if(num[i] + num[j] + num[k] == 0) {
	                    ArrayList<Integer> set = new ArrayList<Integer> (); 
	                    set.add(num[i]);
	                    set.add(num[j]);
	                    set.add(num[k]);
	                    ret.add(set);
	                    j++;
	                    k--;
	                    
	                } else if(num[i] + num[j] + num[k] > 0) {
	                    k--;
	                } else if(num[i] + num[j] + num[k] < 0) {
	                    j++;
	                }   
	            }
	        }
	        return ret; 
	   }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
