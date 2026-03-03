package org.dsa.trees.revision;

public class DeleteNode_13 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);

        root.left.right = new TreeNode(40);

        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.delete(root, 50);
        root.preorder(root);
    }
}
