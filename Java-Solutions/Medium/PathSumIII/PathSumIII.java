/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
 */
package Medium.PathSumIII;

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
class PathSumIII {
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        int[] count = { 0 };
        preorder(root, 0L, map, count, targetSum);
        return count[0];
    }

    private static void preorder(TreeNode root, long currSum, Map<Long, Integer> map, int[] count, int targetSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        count[0] += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        preorder(root.left, currSum, map, count, targetSum);
        preorder(root.right, currSum, map, count, targetSum);
        map.put(currSum, map.get(currSum) - 1);
    }
}