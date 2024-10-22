/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
 */
package Medium.CountGoodNodesInBinaryTree;

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
class CountGoodNodesInBinaryTree {
    public static int goodNodes(TreeNode root) {
        int[] count = { 0 };
        getGoodNodesCountRecursive(root, Integer.MIN_VALUE, count);
        return count[0];
    }

    private static void getGoodNodesCountRecursive(TreeNode root, int currMax, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val >= currMax) {
            count[0]++;
        }
        getGoodNodesCountRecursive(root.left, Math.max(currMax, root.val), count);
        getGoodNodesCountRecursive(root.right, Math.max(currMax, root.val), count);
    }

    private static int getGoodNodesCountNonRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreePair> queue = new LinkedList<>();
        queue.add(new TreePair(root, Integer.MIN_VALUE));
        while (!queue.isEmpty()) {
            TreePair removed = queue.remove();
            if (removed.node.val >= removed.currMax) {
                count++;
            }
            if (removed.node.left != null) {
                queue.add(new TreePair(removed.node.left, Math.max(removed.node.val, removed.currMax)));
            }
            if (removed.node.right != null) {
                queue.add(new TreePair(removed.node.right, Math.max(removed.node.val, removed.currMax)));
            }
        }
        return count;
    }

    class TreePair {
        int currMax;
        TreeNode node;

        public TreePair(TreeNode node, int currMax) {
            this.currMax = currMax;
            this.node = node;
        }
    }
}