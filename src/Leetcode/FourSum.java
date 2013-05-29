/*4Sum: 
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
	Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
	The solution set must not contain duplicate quadruplets.
	    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	
	    A solution set is:
	    (-1,  0, 0, 1)
	    (-2, -1, 1, 2)
	    (-2,  0, 0, 2)
 * */

package Leetcode;

import java.util.*;
public class FourSum {
	
	/* use hash table, worst case will still be O(n^3)*/
	public ArrayList<ArrayList<Integer>> fourSum1(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ilist = new ArrayList<Integer>();
		if(num.length<4) return res;

		Arrays.sort(num);
		Map<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
		
		ArrayList<Integer> tlist = new ArrayList<Integer>();
		for(int i=0; i<num.length; i++)
			for(int j=i+1; j<num.length; j++){
				int tempint = target-num[i]-num[j];
				tlist.clear();				
				if(hash.containsKey(tempint))
					tlist = hash.get(tempint);

				tlist.add(i);
				tlist.add(j);
				hash.put(tempint,(ArrayList<Integer>)tlist.clone());				
			}

		int p,q;
		int p_value = Integer.MAX_VALUE;
		int q_value;

		for(p=0; p<num.length-3; p++){
			if(num[p]==p_value)
				continue;
			q = p+1;
			p_value = num[p];

			while(q<num.length-2){
				q_value = num[q];
				int s = num[p] + num[q];
				if(hash.containsKey(s)){
					ArrayList<Integer> t = hash.get(s);
					int count =Integer.MAX_VALUE;
					for(int x=0; x<t.size()-1; x+=2){
						if(t.get(x)<=q || (x>count && num[t.get(x-2)]==num[t.get(x)] && num[t.get(x-1)]==num[t.get(x+1)])){
							continue;
						}
						else{
							ilist.clear();
							ilist.add(num[p]);
							ilist.add(num[q]);
							ilist.add(num[t.get(x)]);
							ilist.add(num[t.get(x+1)]);
							res.add((ArrayList<Integer>)ilist.clone());
							count = x;
						}
					}
				}
				while(++q<num.length-2 && num[q]==q_value);
			}
		}
        
        return res;

    }
	
	/*regular way with O(n^3) time*/
	public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        if(num.length<4) return ret;
        
        for(int i = 0; i < num.length; i++)
        {
            if (i > 0 && num[i] == num[i-1])
                continue;
                
            for(int j = i + 1; j < num.length; j++)
            {
                if (j > i + 1 && num[j] == num[j-1])
                    continue;
                    
                int k = j + 1;
                int t = num.length - 1;
                
                while(k < t)
                {
                    if (k > j + 1 && num[k] == num[k-1])
                    {
                        k++;
                        continue;
                    }
                    
                    if (t < num.length - 1 && num[t] == num[t+1])
                    {
                        t--;
                        continue;
                    }
                    
                    int sum = num[i] + num[j] + num[k] + num[t];
                    
                    if (sum == target)
                    {
                        ilist.clear();
                        ilist.add(num[i]);
                        ilist.add(num[j]);
                        ilist.add(num[k]);
                        ilist.add(num[t]);
                        ret.add((ArrayList<Integer>)ilist.clone());
                        k++;
                    }
                    else if (sum < target)
                        k++;
                    else
                        t--;                        
                }
            }
        }
        
        return ret;
	}
}