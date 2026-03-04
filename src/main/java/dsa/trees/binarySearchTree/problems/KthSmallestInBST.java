package dsa.trees.binarySearchTree.problems;

import dsa.trees.binaryTree.TreeNode;

public class KthSmallestInBST {
    public static int count = 0;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);

        int k = 4;

        System.out.println(kthSmallest(node, k));
    }

    public static int kthSmallest(TreeNode node, int k) {
        return helper(node, new int[]{k});
    }

    public static Integer helper(TreeNode node, int[] k) {
        if (node == null) {
            return null;
        }
        Integer left = helper(node.left, k);
        if (left != null) {
            return left;
        }
        k[0]--;
        if (k[0] == 0) {
            return node.val;
        }
        return helper(node.right, k);
    }

    //OR

//    private static int kthSmallest(TreeNode node, int k) {
//        TreeNode result = dfs(node, k);
//        return result != null ? result.val : -1;
//    }
//
//    private static TreeNode dfs(TreeNode node, int k) {
//        if (node == null) {
//            return null;
//        }
//        TreeNode left = dfs(node.left, k);
//        if (left != null) {
//            return left;
//        }
//        count++;
//        if (count == k) {
//            return node;
//        }
//        return dfs(node.right, k);
//    }
}
