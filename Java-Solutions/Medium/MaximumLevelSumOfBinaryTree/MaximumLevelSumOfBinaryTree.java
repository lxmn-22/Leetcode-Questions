/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 */
package Medium.MaximumLevelSumOfBinaryTree;

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
class MaximumLevelSumOfBinaryTree {
    public static int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;
        int currLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSum = 0;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode removed = queue.remove();
                levelSum += removed.val;
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxSumLevel = currLevel;
            }
            currLevel++;
        }
        return maxSumLevel;
    }
}