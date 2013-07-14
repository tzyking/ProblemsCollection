package Leetcode; 

import java.util.ArrayList;

/*	Combinations:
	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:

	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
*/

public class Combinations {
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> (); 
        int[] arr = new int[k]; 
        findCombin(n, k, arr, ret, 1, 0); 
        return ret;
    }
    
    public void findCombin(int n,int k, int[] arr, ArrayList<ArrayList<Integer>> ret, int start, int level) {
        if(level == k) {
            ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
            for (int i = 0; i < arr.length; i++)
              list.add(Integer.valueOf(arr[i]));
            ret.add(list);
            return;
        }
        
        for(int i = start; i <= n-(k-level-1); i++) {
            arr[level] = i; 
            findCombin(n, k, arr, ret, i+1, level+1); 
        }
    }
}
