package dsa.trees.binaryTree;

public class BalancedBT {
    public static void main(String[] args) {
        BalancedBT bt = new BalancedBT();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(bt.isBalanced(node));
    }

    public boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        postorder(root);
        return balanced;
    }

    private int postorder(TreeNode node) {
        if (node == null) return 0;
        int left = postorder(node.left);
        int right = postorder(node.right);

        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
