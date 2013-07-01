package Leetcode; 
/*
*	Climbing Stairs: 
*	You are climbing a stair case. It takes n steps to reach to the top.
*	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*
*/
public class ClimbingStairs {

	public int climbStairs(int n) {
		int[] waysCounter = new int[n+1];
		waysCounter[0] = 1; 
		waysCounter[1] = 1; 
		for(int i = 2; i < n + 1; i++) {
			waysCounter[i] = waysCounter[i-1] +  waysCounter[i-2]; 
		}
		return waysCounter[n];
	}
}
