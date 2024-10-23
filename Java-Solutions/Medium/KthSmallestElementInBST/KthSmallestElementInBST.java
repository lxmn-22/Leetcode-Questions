package Medium.KthSmallestElementInBST;

/*
 * PROBLEM: 230: Kth Smallest Element in a BST.
 * 
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
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
class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);

        return ans;
    }

    int i = 0;
    int ans = 0;

    public void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        i++;

        if (i == k) {
            ans = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}