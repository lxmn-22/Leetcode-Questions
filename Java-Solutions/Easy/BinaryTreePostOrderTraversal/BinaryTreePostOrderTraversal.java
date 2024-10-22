/* Given the root of a binary tree, return the postorder traversal of its nodes' values. 
Input: root = [1,null,2,3]
Output: [3,2,1]
*/
import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}
      TreeNode(int val) { 
            this.val = val; 
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
class BinaryTreePostOrderTraversal {
      public static List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      TreeNode node = root;
      while (!stack.isEmpty() || node != null) {
            if (node != null) {
                  stack.push(node);
                  result.add(node.val);
                  node = node.right;
            } 
            else {  
                  TreeNode removed = stack.pop();
                  node = removed.left; 
            }
      }
      Collections.reverse(result);
      return result;
  }
  public static void main(String[] args) {
      TreeNode node = new TreeNode(1);
      // node.left = new TreeNode();
      node.right = new TreeNode(2);
      node.right.left = new TreeNode(3);

      List<Integer> result = new ArrayList<>();
      result = postorderTraversal(node);

      System.out.print("The postOrder Traversal is : ");
      for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
      }
      System.out.println();
  }
}