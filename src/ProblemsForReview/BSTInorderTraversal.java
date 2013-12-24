package ProblemsForReview;

import java.util.Stack;
import java.util.ArrayList;
import Util.TreeNode;

//class TreeNode {
//    int value;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class BSTInorderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;

        while(!stack.empty() || p != null){

            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            }else{
                p = stack.pop();
                lst.add(p.value);
                p = p.right;
            }
        }

        return lst;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
