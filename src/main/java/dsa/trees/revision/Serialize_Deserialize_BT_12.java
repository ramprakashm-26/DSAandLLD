package org.dsa.trees.revision;

import org.dsa.trees.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_Deserialize_BT_12 {
    public static void main(String[] args) {
        org.dsa.trees.binaryTree.TreeNode node = new org.dsa.trees.binaryTree.TreeNode(3);
        node.left = new org.dsa.trees.binaryTree.TreeNode(9);
        node.right = new org.dsa.trees.binaryTree.TreeNode(20);
        node.right.left = new org.dsa.trees.binaryTree.TreeNode(7);
        node.right.right = new TreeNode(15);
        String serialized = serialize(node);
        System.out.println(serialized);
        TreeNode deserialized = deserialize(serialized);
        deserialized.preorder(deserialized);
    }

    private static String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(node, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    private static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper (Queue<String> queue) {
        String data = queue.poll();
        if ("null".equals(data)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(data));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}
