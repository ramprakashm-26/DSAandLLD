package org.dsa.trees.revision;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromTraversals_11 {
    static int preIndex = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = constructTree(preorder, inorder);
        System.out.println("Verified Preorder:");
        node.preorder(node);
        System.out.println("Verified Inorder:");
        node.inorder(node);
    }

    private static TreeNode constructTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int value = preorder[preIndex++];
        TreeNode node = new TreeNode(value);
        int mid = map.get(value);
        node.left = construct(preorder, start, mid - 1);
        node.right = construct(preorder, mid + 1, end);
        return node;
    }
}
