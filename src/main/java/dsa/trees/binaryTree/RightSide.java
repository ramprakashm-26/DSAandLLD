package dsa.trees.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSide {
    public static void main(String[] args) {
        RightSide rs = new RightSide();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(5);

        System.out.println(rs.bfs(node));
    }

    private List<Integer> bfs(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --> 0) {
                TreeNode poll = queue.poll();
                if (size == 0) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return result;
    }
}
