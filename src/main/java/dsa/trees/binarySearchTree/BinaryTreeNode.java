package dsa.trees.binarySearchTree;

import dsa.trees.binaryTree.BinaryTree;
import dsa.trees.binaryTree.TreeNode;

import java.util.Stack;

public class BinaryTreeNode {
    BinaryTreeNode previous;

    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public int value;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public static BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public static void inorder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }

    public void stackInorder(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = node;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.value);
            current = current.right;
        }
    }

    public void stackPreorder(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode evicted = stack.pop();
            System.out.println(evicted.value);
            if (evicted.right != null) {
                stack.push(evicted.right);
            }
            if (evicted.left != null) {
                stack.push(evicted.left);
            }
        }
    }

    public void stackPostorder(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            BinaryTreeNode evicted = stack1.pop();
            stack2.push(evicted);
            if (evicted.left != null) {
                stack1.push(evicted.left);
            }
            if (evicted.right != null) {
                stack1.push(evicted.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }
    }

    public boolean searchBstIterative(BinaryTreeNode node, int value) {
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            if (value < node.value) {
                node = node.left;
            } else if (value > node.value) {
                node = node.right;
            }
        }
        return false;
    }

    public boolean searchBstRecursive(BinaryTreeNode node, int value) {
        if (node == null) {
            return false;
        }

        if(node.value == value){
            return true;
        }

        if (value < node.value) {
            return searchBstRecursive(node.left, value);
        } else if (value > node.value) {
            return searchBstRecursive(node.right, value);
        }
        return false;
        //OR..
//        return value < node.value ?
//                searchBstRecursive(node.left, value) :
//                searchBstRecursive(node.right, value);
    }

    public BinaryTreeNode delete(BinaryTreeNode root, int key) {
        if (root == null) return null;

        if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            // Case 1 & 2: Node with 0 or 1 child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Node with 2 children
            BinaryTreeNode minNode = findMin(root.right); // get inorder successor
            root.value = minNode.value;                 // replace value
            root.right = delete(root.right, minNode.value); // delete successor
        }

        return root;
    }

    // Helper to find minimum in right subtree (inorder successor)
    BinaryTreeNode findMin(BinaryTreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //recursive previous approach:
    public boolean isValidBST(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }
        if (!isValidBST(node.left)) {
            return false;
        }
        if (previous != null && node.value <= previous.value) {
            return false;
        }
        previous = node;
        return isValidBST(node.right);
    }

    private boolean isValidMinMax(BinaryTreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && min >= node.value) || (max != null && max <= node.value)) {
            return false;
        }
        boolean leftTree = isValidMinMax(node.left, min, node.value);
        boolean rightTree = isValidMinMax(node.right, node.value, max);
        return leftTree && rightTree;
    }

    public boolean isValidMinMaxApproach(BinaryTreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min!=null && node.value <= min) ||
                (max!= null && node.value >=max)) {
            return false;
        }
        boolean left = isValidMinMaxApproach(node.left, min, node.value);
        boolean right = isValidMinMaxApproach(node.right, node.value, max);

        return left && right;
    }

}
