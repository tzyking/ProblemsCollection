package ProblemsForReview;

public class CharArrayDuplicateRemover {

	public static void removeDuplicatesEff(char[] str) {
		 if (str == null) return;
		 int len = str.length;
		 if (len < 2) return;
		 boolean[] hit = new boolean[256];
		 for (int i = 0; i < 256; ++i) {
			 hit[i] = false;
		 }
		// hit[str[0]] = true;
		 int tail = 0;
		 for (int i = 0; i < len; ++i) {
			 if (!hit[str[i]]) {
				 str[tail] = str[i];
				 ++tail;
				 hit[str[i]] = true;
			 }
		 }
		 str[tail] = 0;
	
		 for(int i = 0; i < tail; i++ )
			 System.out.print(str[i]);
		 
	}
	
	public static void DuplicatorRemover(char[] s){
		int checker = 0, currPosition = 0, l = s.length, val;
		for(int i = 0; i < l; i++){
			val = s[i] - 'a'; 
			if((checker & (1<<val)) > 0){
				if (currPosition == 0) currPosition = i;
			}else{
				if(currPosition > 0){
					s[currPosition] = s[i];
					currPosition++;
				}
				checker |= (1<<val);
			}
			
		}
		
		if (currPosition == 0) currPosition = l; 
		for(int i=0; i < currPosition; i++)
		{
			System.out.print(s[i]);
		}
		
		
	}
	
	public static void CaseSnesitiveDuplicatorRemover(char[] s){
		int LowerCaseChecker = 0, UpperCaseChecker = 0, currPosition = 0, l = s.length, val;
		for(int i = 0; i < l; i++){
			val = s[i] - 'a'; 
					
			if( ((UpperCaseChecker & (1<<(val+32))) > 0 && val < 0 ) || ((LowerCaseChecker & (1<<val)) > 0 && val >= 0)  ){
				if (currPosition == 0) currPosition = i;
			}else{
				if(currPosition > 0){
					s[currPosition] = s[i];
					currPosition++;
				}
				if (val >= 0) 
					LowerCaseChecker |= (1<<val);
				else 
					UpperCaseChecker |= (1<<(val+32));
			}
			
		}
		
		if (currPosition == 0) currPosition = l; 
		for(int i=0; i < currPosition; i++)
		{
			System.out.print(s[i]);
		}
		
		
	}
	
	public static int removeDuplicates(int[] A) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		int n = A.length;
        if (n < 2) return n;
        int len = 1;
        for(int i = 1; i < n; ++i) {
            if(A[i] != A[len - 1]) {
                A[len++] = A[i];
            }
        }
        return len;
    }
	
	public static int removeDuplicates2(int[] A) {

		int n = A.length;
        if (n < 2) return n;
        int curr = 0, runner; 
        
        for(runner = 1; runner < n; runner++)
        {
        	if(A[curr] != A[runner])
        		A[++curr] = A[runner]; 
        }

        return curr;
    }
	
	public static void main(String[] args) {
		
		CharArrayDuplicateRemover.DuplicatorRemover("aba".toCharArray());
		System.out.println();
		CharArrayDuplicateRemover.CaseSnesitiveDuplicatorRemover("abABCCffbD".toCharArray());
		System.out.println();
		CharArrayDuplicateRemover.removeDuplicatesEff("aabac".toCharArray());
		System.out.println();
		int[] a1 = {1, 2, 3, 3, 3, 4, 4, 5, 6, 7};
		int[] a2 = {1, 2, 3, 3, 3, 4, 4, 5, 6, 7};
		System.out.println(removeDuplicates(a1));
		System.out.println(removeDuplicates2(a2));
	}

}
