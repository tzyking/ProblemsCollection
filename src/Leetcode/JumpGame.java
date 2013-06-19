package Leetcode;

/*  Jump Game: 
 * 
 * 	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
	
 *
 * Notes: reach the last index means reach at the last index or pass over the last index. 
 *
 * */

public class JumpGame {

    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 1) return true; 
        boolean ret = false; 
        int i = 0; 
        
        while(i <= A.length-2){
            int jumpLength = A[i]; 
            if(jumpLength == 0) 
                break;
            else if(jumpLength + i >= A.length - 1){
                ret = true;
                break;
            }          
            i = i + jumpLength;
        }
        return ret; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
