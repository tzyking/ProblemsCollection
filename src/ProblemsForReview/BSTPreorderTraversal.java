package ProblemsForReview;

import java.util.ArrayList;
import java.util.Stack;
import Util.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: JT026354
 * Date: 12/22/13
 * Time: 12:34 PM
 * To change this template use File | Settings | File Templates.
 */

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class BSTPreorderTraversal {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if(root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.value);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        return returnList;
    }

    public static void printArrayList(ArrayList<Integer> list) {
        System.out.println("------");
        for(Integer item : list) {
            System.out.print(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        ArrayList<Integer> result = preorderTraversal(n1);
        printArrayList(result);

        result = preorderTraversal(null);
        System.out.println(result.size() == 0);
    }
}
