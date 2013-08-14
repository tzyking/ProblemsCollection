package Util;

public class TreeNode {
	public int value; 
	public TreeNode left; 
	public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public TreeNode getLeftNode() {
        return this.left;
    }

    public TreeNode getRightNode() {
        return this.right;
    }
}


