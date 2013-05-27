/*
 * Letter Combinations of a Phone Number:
 * Given a digit string, return all possible letter combinations that the number could represent.

 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * check image here: http://leetcode.com/onlinejudge
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

package Leetcode;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
	
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
        char[] str = new char[digits.length()];
        String[] arr = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        lc(digits, 0, result, str, arr);
        return result;
	}
	
	 public static void lc(String digits, int level, ArrayList<String> result, char[] str, String[] arr) {
	        if (level == digits.length()) {
	            result.add(new String(str));
	            return;
	        }   
	        int i = Character.digit(digits.charAt(level), 10);
	        char[] choices = arr[i].toCharArray();
	 
	 
	        for (int j = 0; j < choices.length; j++) {
	            str[level] = choices[j];
	            lc(digits, level+1, result, str, arr);
	        }
	 }

	public static void main(String[] args) {
		ArrayList<String> results = LetterCombinationsOfAPhoneNumber.letterCombinations("345");
		System.out.println(results.toString());

	}

}
