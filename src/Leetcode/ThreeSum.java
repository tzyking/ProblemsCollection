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
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if(num.length<3) return res;
	        
	        Arrays.sort(num);
	        for(int i=0;i<num.length-2;i++){
	            if(i==0 || num[i]>num[i-1]){ //avoid duplicate solutions   
	                int j=i+1, 
	                    k=num.length-1;
	         
	                while(j<k){ 
	                    if(num[j]+num[k]==-num[i]){
	                        ArrayList<Integer> temp = new ArrayList<Integer>();
	                        temp.add(num[i]);
	                        temp.add(num[j]);
	                        temp.add(num[k]);
	                        res.add(temp);
	                        k--;
	                        j++;
	                        while(k>j && num[k]==num[k+1]) k--;//avoid duplicate solutions 

	                        while(j<k && num[j]==num[j-1]) j++;//avoid duplicate solutions 

	                    }else if(num[j]+num[k]>-num[i]){
	                        k--;
	                    }else{
	                        j++;
	                    }
	                }
	            }
	        }
	        return res;
	   }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
