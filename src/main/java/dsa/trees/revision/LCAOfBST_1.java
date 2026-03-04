package dsa.trees.revision;

import dsa.trees.binarySearchTree.BinaryTreeNode;

public class LCAOfBST_1 {
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
        System.out.println(findLca(root, p, q).value);
    }

    private static BinaryTreeNode findLca(BinaryTreeNode node, BinaryTreeNode p, BinaryTreeNode q) {
        if (node == null) {
            return null;
        }
        if (p.value < node.value && q.value < node.value) {
            return findLca(node.left, p, q);
        }
        if (p.value > node.value && q.value > node.value) {
            return findLca(node.right, p, q);
        }
        return node;
    }
}
