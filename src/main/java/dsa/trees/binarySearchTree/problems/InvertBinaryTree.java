package dsa.trees.binarySearchTree.problems;

import dsa.trees.binarySearchTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.left = new BinaryTreeNode(2);
        node.right = new BinaryTreeNode(3);
        node.left.left = new BinaryTreeNode(4);
        node.right.right = new BinaryTreeNode(5);
        invert(node);
        bfs(node);
    }

    public static BinaryTreeNode invert(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);

        return node;
    }

    public static void bfs(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode poll = queue.poll();
            BinaryTreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            System.out.println(poll.value);
        }
    }
}
