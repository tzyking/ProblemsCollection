package Leetcode; 
/*	Search a 2D Matrix: 
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.	
	The first integer of each row is greater than the last integer of the previous row.		
	For example,	

	Consider the following matrix:	

	[
	  [1,   3,  5,  7],	
	  [10, 11, 16, 20],		
	  [23, 30, 34, 50]	
	]
	Given target = 3, return true.
*/

public class SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int up = 0, down = matrix.length-1, middle, i;
	   
	        while(up <= down) {
	            if(up == down) {
	                if(matrix[up][0] > target) {
	                    i = up-1;
	                } else if(matrix[up][0] < target) {
	                    i = up;
	                }
	                else
	                    return true;
	                if (i < 0) return false;
	                return binarySearch(matrix[i], target);
	            }
	            middle = up + (down-up)/2;
	            if(matrix[middle][0] < target)
	                up = middle+1;
	            else if(matrix[middle][0] > target) {
	                down = middle-1;
	            }
	            else
	                return true;
	        }
	        
	        if(down >= 0 && matrix[down][0] < target) {
	            return binarySearch(matrix[down], target);
		     } 
	         return false;
	   }
	   
	   public static boolean binarySearch(int[] arr, int target) {
	       int left = 0, right = arr.length-1; 
	       while(left <= right) {
	           int middle = left + (right-left)/2; 
	           if(arr[middle] > target) {
	               right = middle - 1; 
	           }else if(arr[middle] < target) {
	               left = middle + 1;
	           }else{
	               return true;
	           }
	       }
	       return false;
	   }
	
}
