package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binaryTree.TreeNode;

public class SubTree {
    public static void main(String[] args) {
        TreeNode mainTree = new TreeNode(3);
        mainTree.left = new TreeNode(4);
        mainTree.right = new TreeNode(5);
        mainTree.left.left = new TreeNode(1);
        mainTree.left.right = new TreeNode(2);

        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);

        System.out.println("Is SubTree: "+isSubTree(mainTree, subTree));
    }

    public static boolean isSubTree(TreeNode mainTree, TreeNode subTree) {
        if (mainTree == null) {
            return false;
        }
        if (isSame(mainTree, subTree)) {
            return true;
        }
        boolean left = isSubTree(mainTree.left, subTree);
        boolean right = isSubTree(mainTree.right, subTree);
        return left || right;
        //OR
//        return isSubTree(mainTree.left, subTree) || isSubTree(mainTree.right, subTree);
    }

    public static boolean isSame(TreeNode mainTree, TreeNode subTree) {
        if (mainTree == null && subTree == null) {
            return true;
        }
        if (mainTree == null || subTree == null) {
            return false;
        }
        if (mainTree.val != subTree.val) {
            return false;
        }
        boolean left = isSame(mainTree.left, subTree.left);
        boolean right = isSame(mainTree.right, subTree.right);
        return left && right;
        //OR
        //return isSame(mainTree.left, subTree.left) && isSame(mainTree.right, subTree.right);
    }
}
