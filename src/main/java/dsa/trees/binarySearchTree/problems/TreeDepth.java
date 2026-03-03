package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binarySearchTree.BinaryTreeNode;

public class TreeDepth {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.left = new BinaryTreeNode(2);
        node.right = new BinaryTreeNode(3);
        node.left.left = new BinaryTreeNode(4);
        node.right.right = new BinaryTreeNode(5);
        System.out.println("Depth of the tree: "+findDepth(node));
    }

    public static int findDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findDepth(node.left);
        int right = findDepth(node.right);

        return 1 + Math.max(left, right);
    }
}
