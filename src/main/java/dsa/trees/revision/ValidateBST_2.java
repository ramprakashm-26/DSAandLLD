package org.dsa.trees.revision;

import org.dsa.trees.binarySearchTree.BinaryTreeNode;

public class ValidateBST_2 {
    static BinaryTreeNode previous = null;
    public static void main(String[] args) {
        BinaryTreeNode node1 = null;
        int [] values1 = {5, 3, 8};
        for (int value : values1) {
            node1 = BinaryTreeNode.insert(node1, value);
        }
    }

    private static boolean isValidBst(BinaryTreeNode node) {
        if (node == null) return true;
        if (!isValidBst(node.left)) {
            return false;
        }
        if (previous != null && previous.value >= node.value) {
            return true;
        }
        previous = node;
        return isValidBst(node.right);
    }

    private static boolean isValidBst2(BinaryTreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && min >= node.value) || (max != null && max <= node.value)) {
            return false;
        }
        return isValidBst2(node.left, min, node.value) && isValidBst2(node.right, node.value, max);
    }
}
