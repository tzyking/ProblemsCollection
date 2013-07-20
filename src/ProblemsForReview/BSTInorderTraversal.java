package ProblemsForReview;
import java.util.Stack;

import Util.TreeNode;

public class BSTInorderTraversal {

	public static void inorderNoRecursive(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode> ();
		TreeNode curr = root; 
		do {
			while(curr != null) {
				s.push(curr); 
				curr = curr.left; 
			}
			
			do {
				curr = s.peek();
				System.out.println(curr.value); 
				s.pop();
				
				if(curr.right != null) {
					curr = curr.right;
					break; 
				}
			} while(!s.isEmpty());
			
		} while(!s.isEmpty());
	}
	//TODO: implement BST iterator with java version: http://coolshell.cn/articles/9886.html 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
