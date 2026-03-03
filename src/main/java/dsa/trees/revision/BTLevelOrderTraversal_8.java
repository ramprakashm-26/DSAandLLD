package org.dsa.trees.revision;

import org.dsa.trees.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal_8 {
    public static void main(String[] args) {
        org.dsa.trees.binaryTree.TreeNode node = new org.dsa.trees.binaryTree.TreeNode(3);
        node.left = new org.dsa.trees.binaryTree.TreeNode(9);
        node.right = new org.dsa.trees.binaryTree.TreeNode(20);
        node.right.left = new org.dsa.trees.binaryTree.TreeNode(7);
        node.right.right = new org.dsa.trees.binaryTree.TreeNode(15);
        System.out.println(levelOrder(node));
    }

    public static List<List<Integer>> levelOrder(org.dsa.trees.binaryTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<org.dsa.trees.binaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subset = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                subset.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            result.add(subset);
        }
        return result;
    }
}
