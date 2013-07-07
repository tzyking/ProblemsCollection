package Leetcode; 
/*	Longest Substring Without Repeating Characters: 
	Given a string, find the length of the longest substring without repeating characters.
	For example, the longest substring without repeating letters for "abcabcbb" is "abc",
	 which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
	
	example: 
	"abcabcbb"  =>	3
	"" 	    => 	0
	"abcddcbae" =>	5
*/

/*
you would need two indices to record the head and the tail of the current substring. 
Since i and j both traverse at most n steps, the worst case would be 2n steps, 
which the run time complexity must be O(n).
*/
public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] CharS = s.toCharArray();
        int n = s.length(); 
        int i = 0, j = 0; 
        int MaxLength = 0; 
        boolean[] exist = new boolean[256]; 
        while(j < n) {
            if(exist[CharS[j]]) {
                if (MaxLength < j-i) MaxLength = j-i; 
                while(CharS[i] != CharS[j]) {
                    exist[CharS[i]] = false; 
                    i++; 
                }
                i++;
            }else {
                exist[CharS[j]] = true;  
            }
            j++; 
        }
        
        if(MaxLength < n-i) MaxLength = n-i; 
        
        return MaxLength; 
    }	
}
