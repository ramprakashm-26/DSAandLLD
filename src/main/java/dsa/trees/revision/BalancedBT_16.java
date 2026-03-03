package org.dsa.trees.revision;

import org.dsa.trees.binaryTree.TreeNode;

public class BalancedBT_16 {
    public static boolean balanced = true;

    public static void main(String[] args) {
        org.dsa.trees.binaryTree.TreeNode node = new org.dsa.trees.binaryTree.TreeNode(3);
        node.left = new org.dsa.trees.binaryTree.TreeNode(1);
        node.right = new org.dsa.trees.binaryTree.TreeNode(4);
        node.left.left = new org.dsa.trees.binaryTree.TreeNode(3);
        node.right.left = new org.dsa.trees.binaryTree.TreeNode(1);
        node.right.right = new org.dsa.trees.binaryTree.TreeNode(5);
        isBalanced(node);
        System.out.println(balanced);
    }

    public static boolean isBalanced(org.dsa.trees.binaryTree.TreeNode root) {
        getHeight(root);
        return balanced;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1 && balanced) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
