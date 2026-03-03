package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binaryTree.TreeNode;
//2 cases: usual one found on both left and right
//         only found on any one side, where that node itself might be an ancestor
public class LCAOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        TreeNode p = node.left;//5
        TreeNode q = node.left.right.right;//4

        TreeNode result = lowestCommonAncestor(node, p, q);
        System.out.println("LCA of Binary Tree: "+ result.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

}
