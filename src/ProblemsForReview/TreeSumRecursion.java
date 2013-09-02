package ProblemsForReview;

import Util.TreeNode;

/**
 * Tree sum recursion:
 * Given BST, return all from-root-to-leaf paths whose sum equal to a specified value.
 *
 * Example:
 *                  3
 *                /   \
 *               /     \
 *              6       7
 *             / \     / \
 *            4   5   2   4
 *
 * expected sum: 14
 *
 * output:
 *  3，6，5
 *  3，7，4
 */


import java.util.ArrayList;
import java.util.List;

public class TreeSumRecursion {

    private static int expectSum = 22;

    public static void main(String[] args) {

        // declare tree
        TreeNode root = new TreeNode(12,
                        new TreeNode(6, new TreeNode(4), new TreeNode(7)),
                        new TreeNode(3, new TreeNode(2), new TreeNode(7))
                        );

        List<TreeNode> list = new ArrayList<TreeNode>();
        walk(root,list);
    }

    private static void walk(TreeNode node, List<TreeNode> walkNodes) {
        walkNodes.add(node);
        if (node.isLeaf()) {
            int sum = 0;
            for (TreeNode item : walkNodes) {
                sum += item.getValue();
            }

            if (sum == expectSum) {
                for (TreeNode n : walkNodes)
                    System.out.print(" " + n.getValue());
                System.out.println();
            }
        } else {
            if (node.getLeftNode() != null)
                walk(node.getLeftNode(),walkNodes);
            if (node.getRightNode() != null)
                walk(node.getRightNode(),walkNodes);
        }
        walkNodes.remove(walkNodes.size() - 1);
    }
}