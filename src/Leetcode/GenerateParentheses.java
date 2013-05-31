package Leetcode;
/*	Generate Parentheses:
 * 
 * 	Given n pairs of parentheses, write a function to generate all 
 * 	combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"
*/


import java.util.ArrayList;

public class GenerateParentheses {

	public static ArrayList<String> generator(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> ret = new ArrayList<String>(); 
		char[] str = new char[n*2]; 
		
		gp(n, 0, ret, str, 0);
        
		return ret;
	}

	public static void gp(int num, int level, ArrayList<String> result, char[] str, int balance){
		if(balance < 0 ) return; 
		if(level ==  (num * 2) && balance == 0){
			result.add(new String(str));  
		}
		
		if(level == (num * 2)) return;    /*note: when level is exceed upper bound and balance != 0, it should return*/
		
		for(int i = 0; i < 2; i++){
			if(i == 0){
				str[level] = '('; 
				gp(num, level+1, result, str, balance+1); 
			}
			else{
				str[level] = ')';
				gp(num, level+1, result, str, balance-1); 
			}
		}
	}
    
    public static void main(String[] args) {
    	ArrayList<String> result = GenerateParentheses.generator(3);
    	System.out.println(result.toString());
    }

}
