package dsa.trees.revision;

import dsa.trees.binaryTree.TreeNode;

public class CountGoodNodes_15 {
    public static int count = 0;
    public static void main(String[] args) {
        dsa.trees.binaryTree.TreeNode node = new dsa.trees.binaryTree.TreeNode(3);
        node.left = new dsa.trees.binaryTree.TreeNode(1);
        node.right = new dsa.trees.binaryTree.TreeNode(4);
        node.left.left = new dsa.trees.binaryTree.TreeNode(3);
        node.right.left = new dsa.trees.binaryTree.TreeNode(1);
        node.right.right = new TreeNode(5);
        countGoodNodes(node, node.val);
        System.out.println(count);
    }

    private static void countGoodNodes(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        if (node.val >= value) {
            value = node.val;
            count++;
        }
        countGoodNodes(node.left, node.val);
        countGoodNodes(node.right, node.val);
    }
}
