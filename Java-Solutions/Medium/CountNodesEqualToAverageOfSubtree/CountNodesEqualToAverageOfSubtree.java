/*
Given the root of a binary tree, return the number of nodes where the value of the node is equal 
to the average of the values in its subtree.
Note:
The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CountNodesEqualToAverageOfSubtree {
    public int averageOfSubtree(TreeNode root) {
        int[] result = {0};
        helper(root, result);
        return result[0];
    }
    private int[] helper(TreeNode root, int[] result) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = helper(root.left, result);
        int[] right = helper(root.right, result);
        int sum = left[0] + right[0] + root.val;
        int numOfNodes = left[1] + right[1] + 1;
        int average = sum / numOfNodes;

        if (root.val == average) {
            result[0]++;
        }
        return new int[]{sum, numOfNodes};
    }
}