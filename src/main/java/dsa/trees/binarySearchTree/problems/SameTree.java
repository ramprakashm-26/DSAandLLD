package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binarySearchTree.BinaryTreeNode;

public class SameTree {
    public static void main(String[] args) {
        BinaryTreeNode tree1 = new BinaryTreeNode(1);
        tree1.left = new BinaryTreeNode(2);
        tree1.right = new BinaryTreeNode(3);

        BinaryTreeNode tree2 = new BinaryTreeNode(1);
        tree2.left = new BinaryTreeNode(2);
        tree2.right = new BinaryTreeNode(3);
        System.out.println("Same Tree: "+isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.value != tree2.value) {
            return false;
        }
        boolean left = isSameTree(tree1.left, tree1.left);
        boolean right = isSameTree(tree2.right, tree2.right);
        return left && right;
//        return isSameTree(tree1.left, tree2.left) &&
//                isSameTree(tree1.right, tree2.right);
    }
}
