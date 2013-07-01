package Leetcode;
/*
*	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
*
	For example,
	Given n = 3,
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]	
*
*/
public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		generateOrder(ret, 0, n, 0, n, 1);
		return ret;
	}
	public static void generateOrder (int[][] m, int RowS, int RowL, int ColS, int ColL, int val) {
		if(RowL <= 0 || ColL <= 0) return;
		if(RowL == 1) {
			for(int i = ColS; i < ColS + ColL; i++) {
				m[RowS][i] = val++;
			}
			return;
		}
		if(ColL == 1) {
			for(int i = RowS; i < RowS + RowL; i++) {
				m[i][ColS] = val++;
			}
			return;
		}

		for(int i = ColS; i < ColS + ColL - 1; i++)     	// up side
			m[RowS][i] = val++;
		for(int i = RowS; i < RowS + RowL - 1; i++)     	//right side
			m[i][ColS + ColL-1] = val++;
		for(int i = 0; i < ColL-1; i++)		        	//bottom side
			m[RowS+RowL-1][ColS+ColL-1-i] = val++;
		for(int i = 0; i < RowL-1; i++) 			//left side
			m[RowS+RowL-1-i][ColS] = val++;
		genreateOrder(m, RowS+1, RowL-2, ColS+1, ColL-2, val);
	}
}
