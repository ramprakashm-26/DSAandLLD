package org.dsa.trees.binaryTree;

class DiameterOfTree {
    public int diameter = 0;
    public static void main(String[] args) {
        DiameterOfTree dt = new DiameterOfTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(dt.diameterOfBinaryTree(node));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
