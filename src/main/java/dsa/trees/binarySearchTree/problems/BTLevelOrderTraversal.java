package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(15);
        System.out.println(levelOrderTraversal(node));
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode node) {
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelList = new ArrayList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                level.add(poll.val);
            }
            levelList.add(level);
        }
        return levelList;
    }
}
