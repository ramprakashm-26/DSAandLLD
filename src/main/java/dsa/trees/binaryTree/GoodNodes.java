package dsa.trees.binaryTree;

public class GoodNodes {
    public static void main(String[] args) {
        GoodNodes gn = new GoodNodes();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(5);
        System.out.println(gn.goodNodes(node));
    }

    public int max = 0, count = 0;
    public int goodNodes(TreeNode root) {
        preorder(root);
        return count;
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            max = node.val;
            count++;
        }
        preorder(node.left);
        preorder(node.right);
    }
}
