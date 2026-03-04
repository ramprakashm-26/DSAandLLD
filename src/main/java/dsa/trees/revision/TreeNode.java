package dsa.trees.revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            TreeNode minNode = minNode(node.right);
            node.val = minNode.val;
            node.right = delete(node.right, minNode.val);
        }
        return node;
    }

    public boolean searchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        return val < node.val ? searchRecursive(node.left, val) : searchRecursive(node.right, val);
    }

    public boolean searchIterative (TreeNode node, int val) {
        while (node != null) {
            if (node.val == val) {
                return true;
            } else if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    private TreeNode minNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);
    }

    public void stackPreorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public void stackInorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            current = current.right;
        }
    }

    public void stackPostorder(TreeNode node) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();
        preStack.push(node);
        while (!preStack.isEmpty()) {
            TreeNode current = preStack.pop();
            postStack.push(current);
            if (current.left != null) {
                preStack.push(current.left);
            }
            if (current.right != null) {
                preStack.push(current.right);
            }
        }
        while (!postStack.isEmpty()) {
            System.out.println(postStack.pop().val);
        }
    }

    public void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
