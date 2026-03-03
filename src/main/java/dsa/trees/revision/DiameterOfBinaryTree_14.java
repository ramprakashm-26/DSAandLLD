package org.dsa.trees.revision;

import org.dsa.trees.binaryTree.TreeNode;

public class DiameterOfBinaryTree_14 {
    public static int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        root.left.left.right.left = new TreeNode(6);
        root.left.left.right.right = new TreeNode(7);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(org.dsa.trees.binaryTree.TreeNode root) {
        dfs(root);
        return diameter;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
