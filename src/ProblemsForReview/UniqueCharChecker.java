package ProblemsForReview;
//150 Problems: 1.1Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?

public class UniqueCharChecker {

	public static boolean isUniqueChars2(String str) {
		 boolean[] char_set = new boolean[256];
		 for (int i = 0; i < str.length(); i++) {
			 int val = str.charAt(i);
			 if (char_set[val]) return false;
			 char_set[val] = true;
		 }
		 return true;
	}
	
	/*
	  Example: for +1 which is 00000001 in binary:
	  00000001 → 11111110
	  11111110 + 1 → 11111111 (−1 in two's complement)  
	  
	  It's because when you are shifting a 32-bit int, 
	  it just takes the last 5 bits of the shift distance. (i.e. mod 32), so -1 mod 32 = 31, 
	  so you are shifting right by 31 bits. 
	  When you are shifting a negative number (the beginning bits of which are all 1s), you end up with a 1. 
	  Similarly, shifting right by -2 is shifting right by 30 bits, etc. 
	  If you shift a long, it would take 6 bits of the shift distance. 
	  See here for the specification of how the shift operators work: 
	  http://java.sun.com/docs/books/jls/third_edition/html/expressions.html#15.19
	 * 
	 * 
	 *
	 */
	
	public static boolean isUniqueChars(String str) {
		 int checker = 0;
		 for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
		 	if ((checker & (1 << val)) > 0) return false;
		 	checker |= (1 << val);
		 }
		 return true;
	 }
	
	

	public static void main(String[] args) {
		System.out.println(isUniqueChars("Att"));

	}

}
