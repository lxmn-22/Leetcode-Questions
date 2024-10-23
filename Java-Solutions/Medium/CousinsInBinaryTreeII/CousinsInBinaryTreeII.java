package Medium.CousinsInBinaryTreeII;

import java.util.*;

/*
 * PROBLEM: 2641: Cousins in Binary Tree 2
 * Given the root of a binary tree, replace the value of each node in the tree
 * with the sum of all its cousins' values.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth with
 * different parents.
 * 
 * Return the root of the modified tree.
 * 
 * Note that the depth of a node is the number of edges in the path from the
 * root node to it.
 * 
 * Example 1:
 * Input: root = [5,4,9,1,10,null,7]
 * Output: [0,0,0,7,7,null,11]
 * Explanation: The diagram above shows the initial binary tree and the binary
 * tree after changing the value of each node.
 * - Node with value 5 does not have any cousins so its sum is 0.
 * - Node with value 4 does not have any cousins so its sum is 0.
 * - Node with value 9 does not have any cousins so its sum is 0.
 * - Node with value 1 has a cousin with value 7 so its sum is 7.
 * - Node with value 10 has a cousin with value 7 so its sum is 7.
 * - Node with value 7 has cousins with values 1 and 10 so its sum is 11.
 * 
 * Example 2:
 * Input: root = [3,1,2]
 * Output: [0,0,0]
 * Explanation: The diagram above shows the initial binary tree and the binary
 * tree after changing the value of each node.
 * - Node with value 3 does not have any cousins so its sum is 0.
 * - Node with value 1 does not have any cousins so its sum is 0.
 * - Node with value 2 does not have any cousins so its sum is 0.
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
class CousinInBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        dfs(new TreeNode[] { root });
        root.val = 0;
        return root;
    }

    private void dfs(TreeNode[] arr) {
        if (arr.length == 0) {
            return;
        }

        int sum = 0;

        for (TreeNode node : arr) {
            if (node == null) {
                continue;
            }
            if (node.left != null) {
                sum += node.left.val;
            }
            if (node.right != null) {
                sum += node.right.val;
            }
        }

        TreeNode[] childArr = new TreeNode[arr.length * 2];
        int index = 0;

        for (TreeNode node : arr) {
            int currentSum = 0;

            if (node.left != null) {
                currentSum += node.left.val;
            }
            if (node.right != null) {
                currentSum += node.right.val;
            }

            if (node.left != null) {
                node.left.val = sum - currentSum;
                childArr[index++] = node.left;
            }
            if (node.right != null) {
                node.right.val = sum - currentSum;
                childArr[index++] = node.right;
            }
        }
        dfs(java.util.Arrays.copyOf(childArr, index));
    }
}