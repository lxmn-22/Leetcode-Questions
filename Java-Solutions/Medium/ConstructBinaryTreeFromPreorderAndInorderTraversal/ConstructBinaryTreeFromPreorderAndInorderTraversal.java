package Medium.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.*;

/*
 * PROBLEM: 105: Construct Binary Tree From Preorder And Inorder Traversal
 * 
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int pre = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, preorder.length - 1, preorder);
    }

    private TreeNode build(int left, int right, int[] preorder) {
        if (pre >= preorder.length) {
            return null;
        }
        if (right < left) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre]);
        int in = map.get(preorder[pre++]);
        root.left = build(left, in - 1, preorder);
        root.right = build(in + 1, right, preorder);

        return root;
    }
}