package Leetcode;

/*
 * pow(x, n):
 * 
 * Implement pow(x, n)
 * 
 * */

public class PowerFunction {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return binaryPow(x, n); 
        
    }
    
    //O(n): O(log n)
    public double binaryPow(double x, int n) {
        if(n < 0){
            x = 1/x; 
            n = n * -1; 
        } 
        
        if (n == 0) { 
            return 1;
        }
        
        double temp = binaryPow(x, n/2);
        
        if(n % 2 == 0 ) {
            return temp * temp; 
        } else {
            return x * temp * temp; 
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
