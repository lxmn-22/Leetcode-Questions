package Medium.BinaryTreeLevelOrderTraversal;

/*
 * PROBLEM: 102: Binary Tree Level Order Traversal
 * 
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int i, l;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            l = q.size();

            for (i = 0; i < l; i++) {
                TreeNode r = q.poll();
                levelList.add(r.val);

                if (r.left != null) {
                    q.add(r.left);
                }
                if (r.right != null) {
                    q.add(r.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return BFS(root);
    }
}