package Leetcode;

import java.util.*;

/*
 * Anagrams:
 * 
 * Given an array of strings, return all groups of strings that are anagrams.

 * Note: All inputs will be in lower-case.
 * */

public class Anagrams {
	
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> ret = new ArrayList<String> (); 
        HashMap<String, Integer> itemChecker = new HashMap<String, Integer> (); 
        
        for(int i = 0; i < strs.length; i++){
            char[] item = strs[i].toCharArray(); 
            Arrays.sort(item);
            String strItem = String.valueOf(item); 
            
            if (itemChecker.containsKey(strItem)){
                if(itemChecker.get(strItem) != -1){
                    ret.add(strs[itemChecker.get(strItem)]); 
                    itemChecker.put(strItem, -1); 
                }
                ret.add(strs[i]);
            } else {
                itemChecker.put(strItem, i); 
            }
        }
        
        return ret; 
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
