package dsa.trees.revision;

import dsa.trees.binaryTree.TreeNode;

public class KthSmallestInBst_9 {
    public static int count = 0, value = 0;
    public static void main(String[] args) {
        dsa.trees.binaryTree.TreeNode node = new dsa.trees.binaryTree.TreeNode(5);
        node.left = new dsa.trees.binaryTree.TreeNode(3);
        node.right = new dsa.trees.binaryTree.TreeNode(6);
        node.left.left = new dsa.trees.binaryTree.TreeNode(2);
        node.left.right = new dsa.trees.binaryTree.TreeNode(4);
        node.left.left.left = new TreeNode(1);

        int k = 4;
        System.out.println(findKthSmallest(node, k));
        count = 0;
        findKth(node, k);
        System.out.println(value);
    }

    private static Integer findKthSmallest(TreeNode node, int k) {
        if (node == null) return null;
        Integer left = findKthSmallest(node.left, k);
        if (left != null) {
            return left;
        }
        if(++count == k){
            return node.val;
        }
        return findKthSmallest(node.right, k);
    }

    private static void findKth(TreeNode node, int k) {
        if (node == null) return;
        findKth(node.left, k);
        if (++count == k && value == 0) {
            value = node.val;
            return;
        }
        findKth(node.right, k);
    }
}
