package dsa.trees.revision;

import dsa.trees.binaryTree.TreeNode;

public class LCAOfBT_7 {
    public static void main(String[] args) {
        dsa.trees.binaryTree.TreeNode node = new dsa.trees.binaryTree.TreeNode(3);
        node.left = new dsa.trees.binaryTree.TreeNode(5);
        node.right = new dsa.trees.binaryTree.TreeNode(1);
        node.left.left = new dsa.trees.binaryTree.TreeNode(6);
        node.left.right = new dsa.trees.binaryTree.TreeNode(2);
        node.right.left = new dsa.trees.binaryTree.TreeNode(0);
        node.right.right = new dsa.trees.binaryTree.TreeNode(8);
        node.left.right.left = new dsa.trees.binaryTree.TreeNode(7);
        node.left.right.right = new dsa.trees.binaryTree.TreeNode(4);

        dsa.trees.binaryTree.TreeNode p = node.left;//5
        TreeNode q = node.left.right.right;//4
        System.out.println(findLca(node, p, q).val);
    }

    private static TreeNode findLca(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (node == p || node == q)
            return node;
        TreeNode left = findLca(node.left, p, q);
        TreeNode right = findLca(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}
