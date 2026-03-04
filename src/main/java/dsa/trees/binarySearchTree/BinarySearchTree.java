package dsa.trees.binarySearchTree;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinaryTreeNode node = null;
        int [] values = {8, 3, 5, 9, 2};
        for (int value : values) {
            node = BinaryTreeNode.insert(node, value);
        }
        System.out.println("BST Inorder - ASC");
        BinaryTreeNode.inorder(node);

        System.out.println("BST search iterative");
        System.out.println(node.searchBstIterative(node, 5));

        System.out.println("BST search recursive");
        System.out.println(node.searchBstRecursive(node, 3));

        System.out.println("BST Delete");
        System.out.println(node.delete(node, 3));
        BinaryTreeNode.inorder(node);

        System.out.println("Is valid BST");
        BinaryTreeNode node1 = null;
        int [] values1 = {5, 3, 8};
        for (int value : values1) {
            node1 = BinaryTreeNode.insert(node1, value);
        }
        System.out.println(node1.isValidBST(node1));

        System.out.println("Min max is valid BST");
        System.out.println(node1.isValidMinMaxApproach(node1, null, null));
    }
}
