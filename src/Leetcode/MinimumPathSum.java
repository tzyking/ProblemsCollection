package Leetcode; 
/* 	Minimum Path Sum:
*	Given a m x n grid filled with non-negative numbers, find a path 
*	from top left to bottom right which minimizes the sum of all numbers along its path.
*
*	Note: You can only move either down or right at any point in time.
*/
public class MinimumPathSum {
   public int minPathSum(int[][] grid) {
	   int m = grid.length;
	   int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int temp = grid[i][j];
                if(i-1 >= 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }
                
                if(j-1 >= 0 && i-1 >= 0) {                
                    if(temp + grid[i][j-1] < grid[i][j])
                        grid[i][j] = grid[i][j-1] + temp;
                } else if(j-1 >= 0 && i-1 < 0) {
                    grid[i][j] = grid[i][j-1] + temp;
                }
                

            }
        }
        return grid[m-1][n-1];
    }
}
