package dsa.trees.revision;

import dsa.trees.binaryTree.TreeNode;

public class SubTree_6 {
    public static void main(String[] args) {
        dsa.trees.binaryTree.TreeNode mainTree = new dsa.trees.binaryTree.TreeNode(3);
        mainTree.left = new dsa.trees.binaryTree.TreeNode(4);
        mainTree.right = new dsa.trees.binaryTree.TreeNode(5);
        mainTree.left.left = new dsa.trees.binaryTree.TreeNode(1);
        mainTree.left.right = new dsa.trees.binaryTree.TreeNode(2);

        dsa.trees.binaryTree.TreeNode subTree = new dsa.trees.binaryTree.TreeNode(4);
        subTree.left = new dsa.trees.binaryTree.TreeNode(1);
        subTree.right = new TreeNode(2);
        System.out.println(isSubTree(mainTree, subTree));

    }

    private static boolean isSubTree(TreeNode root, TreeNode subTree) {
        if (isSame(root, subTree)) {
            return true;
        }
        return isSubTree(root.left, subTree) || isSubTree(root.right, subTree);
    }

    private static boolean isSame(TreeNode root, TreeNode subTree) {
        if (root == null && subTree == null) return true;
        if (root == null || subTree == null) return false;
        if (root.val != subTree.val) return false;
        return isSame(root.left, subTree.left) && isSame(root.right, subTree.right);
    }
}
