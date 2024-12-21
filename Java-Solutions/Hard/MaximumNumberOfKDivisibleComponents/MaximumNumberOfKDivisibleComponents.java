package Hard.MaximumNumberOfKDivisibleComponents;

import java.util.*;

/*
 * PROBLEM: 2872: Maximum Number of K-Divisible Components
 * 
 * There is an undirected tree with n nodes labeled from 0 to n - 1. You are
 * given the integer n and a 2D integer array edges of length n - 1, where
 * edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi
 * in the tree.
 * 
 * You are also given a 0-indexed integer array values of length n, where
 * values[i] is the value associated with the ith node, and an integer k.
 * 
 * A valid split of the tree is obtained by removing any set of edges, possibly
 * empty, from the tree such that the resulting components all have values that
 * are divisible by k, where the value of a connected component is the sum of
 * the values of its nodes.
 * 
 * Return the maximum number of components in any valid split.
 * 
 * Example 1:
 * Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
 * Output: 2
 * Explanation: We remove the edge connecting node 1 with 2. The resulting split
 * is valid because:
 * - The value of the component containing nodes 1 and 3 is values[1] +
 * values[3] = 12.
 * - The value of the component containing nodes 0, 2, and 4 is values[0] +
 * values[2] + values[4] = 6.
 * It can be shown that no other valid split has more than 2 connected
 * components.
 * 
 * Example 2:
 * Input: n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values =
 * [3,0,6,1,5,2,1], k = 3
 * Output: 3
 * Explanation: We remove the edge connecting node 0 with 2, and the edge
 * connecting node 0 with 1. The resulting split is valid because:
 * - The value of the component containing node 0 is values[0] = 3.
 * - The value of the component containing nodes 2, 5, and 6 is values[2] +
 * values[5] + values[6] = 9.
 * - The value of the component containing nodes 1, 3, and 4 is values[1] +
 * values[3] + values[4] = 6.
 * It can be shown that no other valid split has more than 3 connected
 * components.
 */
class MaximumNumberOfKDivisibleComponents {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        // Step 1: Create adjacency list from edges.
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        // Step 2: Initialize component count.
        int[] componentCount = new int[1]; // Use array to pass by reference.

        // Step 3: Start DFS traversal from node 0.
        dfs(0, -1, adjList, values, k, componentCount);

        // Step 4: Return the total number of components.
        return componentCount[0];
    }

    private int dfs(int currentNode, int parentNode, List<Integer>[] adjList, int[] nodeValues, int k,
            int[] componentCount) {
        // Step 1: Initialize sum for the current subtree.
        int sum = 0;

        // Step 2: Traverse all neighbors.
        for (int neighbourNode : adjList[currentNode]) {
            if (neighbourNode != parentNode) {
                // Recursive call to process the subtree rooted at the neighbor.
                sum += dfs(neighbourNode, currentNode, adjList, nodeValues, k, componentCount);
                // Ensure the sum stays within bounds.
                sum %= k;
            }
        }

        // Step 3: Add the value of the current node to the sum.
        sum += nodeValues[currentNode];
        sum %= k;

        // Step 4: Check if the sum is divisible by k.
        if (sum == 0) {
            componentCount[0]++;
        }

        // Step 5: Return the computed sum for the current subtree.
        return sum;
    }
}