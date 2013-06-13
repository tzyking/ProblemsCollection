package Leetcode;

import java.util.ArrayList;

/*	Permutations:
 * 	Given a collection of numbers, return all possible permutations.
 * 
//	For example,
//	[1,2,3] have the following permutations:
//	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * 
 * */

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> (); 
        RecurPermute(num, 0, ret);
        return ret;
        
    }
    
    public void RecurPermute(int[] num, int level, ArrayList<ArrayList<Integer>> ret){
        if(level == num.length - 1){
            ArrayList<Integer> unit = new ArrayList<Integer> (); 
            for(int i = 0; i < num.length; i++){
                unit.add(num[i]);
            }
            ret.add(unit);
            return; 
        }
        
        for(int i = level; i < num.length; i++){
            swap(num, level, i);
            RecurPermute(num, level+1, ret); 
            swap(num, level, i);
        }
        
    }
    
    public void swap(int[] num, int i, int j){
            int temp = num[i]; 
            num[i] = num[j];
            num[j] =temp; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
