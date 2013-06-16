package ProblemsForReview;

import java.util.*;
import Util.*;

public class BSTPostOrderTraversal {

	public static void PostOrderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode> ();
		TreeNode curr = root; 
		do {
			while(curr != null){
				if(curr.right != null)
					st.push(curr.right); 
				st.push(curr);
				curr = curr.left;
			}
			
			curr = st.pop();
			if(curr.right == st.peek()){
				st.pop();
				st.push(curr);
				curr = curr.right;
			}else {
				System.out.print(curr.value); 
				curr = null;
			}
		} while(!st.isEmpty());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
