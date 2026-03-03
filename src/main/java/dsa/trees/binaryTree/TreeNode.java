package org.dsa.trees.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println("Node value: " + node.val);
        inorder(node.right);
    }

    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("Node value: " + node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println("Node value: " + node.val);
    }

    public static void levelOrderBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void stackPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void stackInorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.val);
            current = current.right;
        }
    }

    public static void stackPostOrder(TreeNode node) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(node);

        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }
}
