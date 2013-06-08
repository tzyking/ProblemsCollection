package Leetcode;

/*
 * Substring with Concatenation of All Words
 * 
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word 
 * in L exactly once and without any intervening characters.

	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
	
	You should return the indices: [0,9].
	(order does not matter).
 * */

import java.util.ArrayList;
import java.util.Hashtable;

public class SubstringWithConcatenationOfAllWords {

	/* O(n) = n(S.length()) * m(L.length) */
	
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
	   // Start typing your Java solution below
       // DO NOT write main() function
		Hashtable<String, Integer> ItemCounter = new Hashtable<String, Integer> (); 
		Hashtable<String, Integer> CurrString = new Hashtable<String, Integer> (); 
		ArrayList<Integer> ret = new ArrayList<Integer> (); 
		int n = L.length;
		if( n < 1 ) return ret; 
		int m = L[0].length(); 
		
		for(int i = 0; i < L.length; i++)
		{
			int NewValue = ItemCounter.containsKey(L[i]) ? ItemCounter.get(L[i]) + 1 : 1; 
			ItemCounter.put(L[i], NewValue);
		}
       
		for(int j = 0; j <= S.length() - (m * n); j++)
		{
			CurrString.clear(); 
			int k = 0;
			for(k = 0; k < n; k++)
			{
				String Item = S.substring(j + (k * m), j + (k * m) + m); 
				if(!ItemCounter.containsKey(Item))
					break;
				int value = CurrString.containsKey(Item) ? CurrString.get(Item) + 1 : 1; 
				CurrString.put(Item, value);
				
				if(CurrString.get(Item) > ItemCounter.get(Item))
					break;
			}
			if(k == n)
				ret.add(j); 
		}
       return ret; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
