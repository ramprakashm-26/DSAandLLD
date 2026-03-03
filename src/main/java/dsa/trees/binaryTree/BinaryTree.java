package org.dsa.trees.binaryTree;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println("Inorder");
        node.inorder(node);

        System.out.println("Preorder");
        node.preorder(node);

        System.out.println("Postorder");
        node.postorder(node);

        System.out.println("BFS");
        TreeNode.levelOrderBfs(node);

        System.out.println("DFS - Stack Preorder");
        TreeNode.stackPreOrder(node);

        System.out.println("DFS - Stack Inorder");
        TreeNode.stackInorder(node);

        System.out.println("DFS - Stack Posorder");
        TreeNode.stackPostOrder(node);
    }
}
