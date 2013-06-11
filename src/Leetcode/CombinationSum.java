package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;


//  Combination Sum:
//	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C 
//	where the candidate numbers sums to T.
//	The same repeated number may be chosen from C unlimited number of times.
//	Note:
//	All numbers (including target) will be positive integers.
//	Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
//	The solution set must not contain duplicate combinations.
//	For example, given candidate set 2,3,6,7 and target 7,
//	A solution set is:
//	[7]
//	[2, 2, 3] 



public class CombinationSum {
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> (); 
        ArrayList<Integer> CurrSet = new ArrayList<Integer> (); 
        Arrays.sort(candidates);
        
        combin(ret, 0, candidates, target, CurrSet); 
        
        return ret;
        
    }
    
    
    public void combin(ArrayList<ArrayList<Integer>> ret, int level, int[] candidates, int target, ArrayList<Integer> CurrSet) {
        if(target == 0){
            ArrayList<Integer> FitList = new ArrayList<Integer> (); 
            FitList.addAll(CurrSet);
            ret.add(FitList);
            return;    
        }
        else if(target < 0 || level >= candidates.length)
            return; 
        else if(target >= candidates[level]){
            for(int i = level; i < candidates.length; i++){
                CurrSet.add(candidates[i]);
                combin(ret, i, candidates, target - candidates[i], CurrSet); 
                CurrSet.remove(CurrSet.size() - 1);
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
