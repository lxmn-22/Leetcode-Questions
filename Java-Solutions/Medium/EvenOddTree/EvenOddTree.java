/*
 * A binary tree is named Even-Odd if it meets the following conditions:
 * 
 * The root of the binary tree is at level index 0, its children are at level
 * index 1, their children are at level index 2, etc.
 * For every even-indexed level, all nodes at the level have odd integer values
 * in strictly increasing order (from left to right).
 * For every odd-indexed level, all nodes at the level have even integer values
 * in strictly decreasing order (from left to right).
 * Given the root of a binary tree, return true if the binary tree is Even-Odd,
 * otherwise return false.
 * 
 * Example 1:
 * Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * Output: true
 * Explanation: The node values on each level are:
 * Level 0: [1]
 * Level 1: [10,4]
 * Level 2: [3,7,9]
 * Level 3: [12,8,6,2]
 * Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all
 * even and decreasing, the tree is Even-Odd.
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
public class EvenOddTree {
    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int[] temp = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                temp[i] = current.val;

                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (level % 2 == 0) {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i] % 2 != 1 || (i > 0 && temp[i] <= temp[i - 1])) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i] % 2 != 0 || (i > 0 && temp[i] >= temp[i - 1])) {
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
}