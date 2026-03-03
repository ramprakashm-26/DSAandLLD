package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binarySearchTree.BinaryTreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(6);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(8);

        root.left.left = new BinaryTreeNode(0);
        root.left.right = new BinaryTreeNode(4);

        root.left.right.left = new BinaryTreeNode(3);
        root.left.right.right = new BinaryTreeNode(5);

        root.right.right = new BinaryTreeNode(9);

        // Assign p and q
        BinaryTreeNode p = root.left.right.left;   // Node with value 3
        BinaryTreeNode q = root.left.right.right;  // Node with value 5

        BinaryTreeNode lowestCommonNode = findLCA(root, p, q);
        System.out.println("Lowest root node: " +lowestCommonNode.value);
    }

    public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.value < root.value && q.value < root.value) {
            return findLCA(root.left, p, q);
        }

        if (p.value > root.value && q.value > root.value) {
            return findLCA(root.right, p, q);
        }

        return root;
    }
}
