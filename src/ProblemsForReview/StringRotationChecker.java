package ProblemsForReview;

public class StringRotationChecker {

	public static boolean isRotation(String s1, String s2) {
		 int len = s1.length();
		 /* check that s1 and s2 are equal length and not empty */
		 if (len == s2.length() && len > 0) {
		 /* concatenate s1 and s1 within new buffer */
			 String s1s1 = s1 + s1;
			 return s1s1.indexOf(s2) > 0;
		 }
		return false;
	}
	public static void main(String[] args) {
		System.out.println(StringRotationChecker.isRotation("apple", "pleap"));

	}

}
