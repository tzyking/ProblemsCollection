package ProblemsForReview;

import java.util.*;
import Util.TreeNode;

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

    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode curr = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.value);
                }

                //go up the tree from left node
                //need to check if there is a right child
                //if yes, push it to stack
                //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    lst.add(curr.value);
                }

                //go up the tree from right node
                //after coming back from right node, process parent node and pop stack.
            }else if(curr.right == prev){
                stack.pop();
                lst.add(curr.value);
            }

            prev = curr;
        }

        return lst;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
