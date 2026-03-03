package org.dsa.trees.revision;

import org.dsa.trees.binaryTree.TreeNode;

public class MaximumPathSum_10 {
    public static int sum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        org.dsa.trees.binaryTree.TreeNode node = new org.dsa.trees.binaryTree.TreeNode(-10);
        node.left = new org.dsa.trees.binaryTree.TreeNode(9);
        node.right = new org.dsa.trees.binaryTree.TreeNode(20);
        node.right.left = new org.dsa.trees.binaryTree.TreeNode(7);
        node.right.right = new TreeNode(15);
        maximumPathSum(node);
        System.out.println(sum);
    }

    private static int maximumPathSum(TreeNode node) {
        if (node == null) return 0;
        int left = maximumPathSum(node.left);
        int right = maximumPathSum(node.right);
        sum = Math.max(sum, (Math.max(left, 0) + Math.max(right, 0)) + node.val);
        return Math.max(Math.max(left, 0), Math.max(right, 0)) + node.val;
    }
}
