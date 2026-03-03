package org.dsa.trees.revision;

import org.dsa.trees.binarySearchTree.BinaryTreeNode;

public class MaximumDepthOfBT_3 {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.left = new BinaryTreeNode(2);
        node.right = new BinaryTreeNode(3);
        node.left.left = new BinaryTreeNode(4);
        node.right.right = new BinaryTreeNode(5);
        System.out.println(maxDepth(node));
    }

    private static int maxDepth(BinaryTreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
