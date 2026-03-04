package dsa.trees.binarySearchTree.problems;

import dsa.trees.binaryTree.TreeNode;

public class MaximumPathSumBT {
    public static int sum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(15);

        helper(node);
        System.out.println(sum);
    }


    public static int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        sum = Math.max(node.val + Math.max(left, 0) + Math.max(right, 0), sum);

        return Math.max(Math.max(left, 0), Math.max(right, 0)) + node.val;
    }
}
