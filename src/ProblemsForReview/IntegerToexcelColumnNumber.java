package ProblemsForReview;

public class IntegerToexcelColumnNumber {

	public static String getNthColumnName(int n) {
	    String name = "";
	    while (n > 0) {
	        n--;
	        name = (char)('A' + n%26) + name;
	        n /= 26;
	    }
	    return name; }


	public static void main(String[] args) {
		System.out.println(getNthColumnName(600));

	}

}
