/*Given the root of a binary tree, return the inorder traversal of its nodes' values.
Input: root = [1,null,2,3]
Output: [1,3,2]
*/
public class BTInorderTraversal {
      public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
              return List.of();
            }
            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
              stack.push(root);
              root = root.left;
            }
            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
              TreeNode removed = stack.pop();
              result.add(removed.val);
              TreeNode rightNode = removed.right;
                  while (rightNode != null) {
                  stack.push(rightNode);
                  rightNode = rightNode.left;
                  }
            }
            return result;
      }
}