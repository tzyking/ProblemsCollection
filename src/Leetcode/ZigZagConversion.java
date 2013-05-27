/*ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

package Leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));    
    }
    
    public static String convert(String s, int n) {
     // Start typing your Java solution below
     // DO NOT write main() function
     StringBuilder sb = new StringBuilder();
     int m = s.length();
     int len = 2 * n - 2;
     for(int i = 0; i < n; i++) {
         for(int base = i; base < m; base += len) {
             sb.append(s.charAt(base));
             if(i > 0 && i < n - 1) {
                 int index = base + len - 2 * i;
                 if(index < m)
                     sb.append(s.charAt(index));
             }
         }
     }
       return sb.toString();
   }

}
