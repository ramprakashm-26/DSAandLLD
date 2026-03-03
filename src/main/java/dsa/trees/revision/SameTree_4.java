package org.dsa.trees.revision;

import org.dsa.trees.binarySearchTree.BinaryTreeNode;

public class SameTree_4 {
    public static void main(String[] args) {
        BinaryTreeNode tree1 = new BinaryTreeNode(1);
        tree1.left = new BinaryTreeNode(2);
        tree1.right = new BinaryTreeNode(3);

        BinaryTreeNode tree2 = new BinaryTreeNode(1);
        tree2.left = new BinaryTreeNode(2);
        tree2.right = new BinaryTreeNode(3);
        System.out.println(isSame(tree1, tree2));
    }

    private static boolean isSame(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.value != node2.value) return false;
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}
