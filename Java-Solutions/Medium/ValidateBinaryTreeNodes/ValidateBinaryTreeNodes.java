/*
You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], 
return true if and only if all the given nodes form exactly one valid binary tree.
If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
Note that the nodes have no values and that we only use the node numbers in this problem.
Example 01:
Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true
 */
import java.util.*;
public class ValidateBinaryTreeNodes {
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];

        for (int node = 0; node < n; node++) {
            int left = leftChild[node];
            int right = rightChild[node];
            if (left != -1) {
                graph.computeIfAbsent(node, k -> new ArrayList<>()).add(left);
                inDegree[left]++;
            }
            if (right != -1) {
                graph.computeIfAbsent(node, k -> new ArrayList<>()).add(right);
                inDegree[right]++;
            }
        }

        List<Integer> rootCandidates = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            if (inDegree[node] == 0) {
                rootCandidates.add(node);
            }
        }

        if (rootCandidates.size() != 1) {
            return false;
        }
        int root = rootCandidates.get(0);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(root);
        seen.add(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph.containsKey(node)) {
                for (int child : graph.get(node)) {
                    if (seen.contains(child)) {
                        return false;
                    }
                    seen.add(child);
                    queue.add(child);
                }
            }
        }

        return seen.size() == n;
    }
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,-1,-1,-1};
        System.out.println("Validating Binary Tree Nodes: "+validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}