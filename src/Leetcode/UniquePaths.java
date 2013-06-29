package Leetcode;

public class UniquePaths {
	
	public static int UniquePathsCounter(int m, int n) {
		int[][] set = new int[n][m];	
		set[0][0] = 1; 
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) continue; 
				int sum = 0; 
				if(j-1 >= 0) sum = sum + set[i][j-1]; 
				if(i-1 >= 0) sum = sum + set[i-1][j];
				set[i][j] = sum;
			}
		}
		return set[n-1][m-1]; 
	}	

	public static void main(String[] args) {
		System.out.println(UniquePathsCounter(1, 10));
	}
}
