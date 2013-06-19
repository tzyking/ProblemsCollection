package Leetcode;

/*	Maximum Subarray: 
 *	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 *	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *	the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * */

public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 1) return A[0]; 
        int[] m = new int[A.length]; 
        int sum = A[0]; 
        m[0] = A[0]; 
        
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i] + m[i-1])
                m[i] = A[i]; 
            else
                m[i] = A[i] + m[i-1]; 
            if (m[i] > sum)
                sum = m[i];
        }
        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
