package Leetcode; 
/*
*	Follow up for "Unique Paths":
*
*	Now consider if some obstacles are added to the grids. How many unique paths would there be?
*
*	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*
*	For example,
*
*	There is one obstacle in the middle of a 3x3 grid as illustrated below.
*
*	[
*	  [0,0,0],
*	  [0,1,0],
*	  [0,0,0]
*	]
*	The total number of unique paths is 2.
*/
public class UniquePathsII {

	public static int pathsCounter(int[][] obstacleGrid) {
	        int r = obstacleGrid.length; 
        	int c = obstacleGrid[0].length; 
	        if(obstacleGrid[0][0] == 1)
        	    return 0;
	        else
        	    obstacleGrid[0][0] = 1;
	        for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
                		if(i != 0 || j != 0) {
                    			if(obstacleGrid[i][j] == 1){
                       	 			obstacleGrid[i][j] = 0; 
                    			} else {
                        			int sum = 0; 
	                        		if(j-1 >= 0) sum = sum + obstacleGrid[i][j-1]; 
			                        if(i-1 >= 0) sum = sum + obstacleGrid[i-1][j];
                			        obstacleGrid[i][j] = sum; 
                    			}
                		}
            	  	 }
        	}
        	return obstacleGrid[r-1][c-1];
	}
	
}
