/*
 * Given the root of a binary tree, return the leftmost value in the last row of
 * the tree.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: 1
 * 
 * Example 2:
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
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
class FindBottomLeftTreeValue {
    public static int findBottomLeftValue(TreeNode root) {
        int last = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();

            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == 0) {
                    // last leftMost val
                    last = curr.val;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return last;
    }
}