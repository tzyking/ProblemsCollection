package Leetcode; 

/*	Set Matrix Zeroes:
	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
*/

public class SetMatrixZeroes {

   public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
	
	//to achieve constant space, we need to use the space of the first row and first col
        //to store information        
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return; 
        
	//1. determine if the first row needs to be set zero because of itself
        //which means are there any zeros in the first row
        boolean ZeroFirstRow = false; 
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                ZeroFirstRow = true; 
                break;
            }
        }
        
	//2. determine if the first col needs to be set zero because of itself
        //which means are there any zeros in the first col
        boolean ZeroFirstCol = false; 
        for(int j = 0; j < matrix.length; j++) {
            if(matrix[j][0] == 0) {
                ZeroFirstCol = true; 
                break;
            }
        }
        
	//3. then we can use the first row and first col to store the information of 
        //the rest elements
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0; 
                    matrix[0][j] = 0; 
                }
            }
        }
        
	//4. set the matrix to zero according to the information stored in the first row and first col
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                     matrix[i][j] = 0; 
                }
            }
        }        
        
	//set the first row
        if(ZeroFirstRow) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0; 
            }
        }
        
	//set the first col
        if(ZeroFirstCol) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
