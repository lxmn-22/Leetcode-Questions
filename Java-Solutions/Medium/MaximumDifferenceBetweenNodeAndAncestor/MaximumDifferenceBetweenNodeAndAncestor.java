/*
Given the root of a binary tree, find the maximum value v for which there exist different nodes 
a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an 
ancestor of b.

Example 1:
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 */
package Medium.MaximumDifferenceBetweenNodeAndAncestor;

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
class MaximumDifferenceBetweenNodeAndAncestor {
    public static int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        int min = root.val, max = root.val;
        diff(root, min, max);
        return diff;
    }

    public int diff = 0;

    public static void diff(TreeNode root, int min, int max) {
        if (root == null)
            return;
        diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff(root.left, min, max);
        diff(root.right, min, max);
    }
}