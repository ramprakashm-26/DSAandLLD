package dsa.trees.revision;

import dsa.trees.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal_8 {
    public static void main(String[] args) {
        dsa.trees.binaryTree.TreeNode node = new dsa.trees.binaryTree.TreeNode(3);
        node.left = new dsa.trees.binaryTree.TreeNode(9);
        node.right = new dsa.trees.binaryTree.TreeNode(20);
        node.right.left = new dsa.trees.binaryTree.TreeNode(7);
        node.right.right = new dsa.trees.binaryTree.TreeNode(15);
        System.out.println(levelOrder(node));
    }

    public static List<List<Integer>> levelOrder(dsa.trees.binaryTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<dsa.trees.binaryTree.TreeNode> queue = new LinkedList<>();
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
