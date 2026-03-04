package dsa.trees.revision;

import dsa.trees.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBT_17 {
    public static void main(String[] args) {
        dsa.trees.binaryTree.TreeNode node = new dsa.trees.binaryTree.TreeNode(1);
        node.left = new dsa.trees.binaryTree.TreeNode(2);
        node.right = new dsa.trees.binaryTree.TreeNode(3);
        node.left.left = new dsa.trees.binaryTree.TreeNode(4);
        node.left.left.left = new TreeNode(5);
        System.out.println(rightSideView(node));
    }

    private static List<Integer> rightSideView(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --> 0) {
                TreeNode current = queue.poll();
                if (size == 0) {
                    result.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }
}
