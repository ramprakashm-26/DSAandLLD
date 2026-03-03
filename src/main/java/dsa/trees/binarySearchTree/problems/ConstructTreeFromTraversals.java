package org.dsa.trees.binarySearchTree.problems;

import org.dsa.trees.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromTraversals {
    public static int preIndex = 0;
    public static Map<Integer, Integer> inorderMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        TreeNode node = buildTree(preorder, inorder, 0, inorder.length - 1);
        TreeNode node = constructTree(preorder, inorder, 0, inorder.length - 1);
        System.out.println("Tree built: "+node);
    }

    //Map approach
    private static TreeNode constructTree (int[] preorder, int[] inorder, int start, int end) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, start, end);
    }

    private static TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int value = preorder[preIndex++];
        TreeNode root = new TreeNode(value);
        int mid = inorderMap.get(value);

        root.left = buildTree(preorder, start, mid - 1);
        root.right = buildTree(preorder, mid + 1, end);
        return root;
    }

    // OR recursive approach

//    private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        int value = preorder[preIndex++];
//        TreeNode root = new TreeNode(value);
//        int mid = findMid(inorder, value, start, end);
//
//        root.left = buildTree(preorder, inorder, start, mid - 1);
//        root.right = buildTree(preorder, inorder, mid + 1, end);
//        return root;
//    }
//

//    private static int findMid(int[] inorder, int value, int start, int end) {
//        for (int i = start; i <= end; i++) {
//            if (inorder[i] == value) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
