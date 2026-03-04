package dsa.trees.revision;

import dsa.trees.binarySearchTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_5 {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.left = new BinaryTreeNode(2);
        node.right = new BinaryTreeNode(3);
        node.left.left = new BinaryTreeNode(4);
        node.right.right = new BinaryTreeNode(5);
        invert(node);
    }

    private static BinaryTreeNode invert(BinaryTreeNode node) {
        if (node == null) return null;
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
        return node;
    }

    private static TreeNode invertByBFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
        return node;
    }
}
