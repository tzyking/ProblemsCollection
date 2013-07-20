package Leetcode; 

import java.util.ArrayList;
import java.util.Arrays;

/*	Subsets:
	Given a set of distinct integers, S, return all possible subsets.

	Note:

	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,3], a solution is:

   [
  	[3],
  	[1],
  	[2],
  	[1,2,3],
  	[1,3],
	[2,3],
	[1,2],
  	[]
    ]

*/

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> (); 
        Arrays.sort(S); 
        ArrayList<Integer> unit = new ArrayList<Integer> (); 
        combine(ret, unit, S, 0); 
        ret.add( new ArrayList<Integer> ()); 
        return ret;
    }
    
    public void combine(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> unit, int[] arr, int start) {
        for(int i=start; i < arr.length; i++) {
            unit.add(arr[i]);
            
            ArrayList<Integer> item= new ArrayList<Integer>();
            item.addAll(unit);
            ret.add(item);
            
            if(i < arr.length-1) 
                combine(ret, unit, arr, i+1); 
            
            unit.remove(unit.size()-1);
        }
    }
}
