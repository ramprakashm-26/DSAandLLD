package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(15);

        //serialize
        String serialized = serialize(node);
        System.out.println(serialized);

        //deserialize
        TreeNode deserializedNode = deserialize(serialized);
        System.out.println(deserializedNode);
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

    private static TreeNode deserialize(String value) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(value.split(",")));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> values) {
        String value = values.poll();
        if (value.equalsIgnoreCase("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializeHelper(values);
        root.right = deserializeHelper(values);
        return root;
    }
}
