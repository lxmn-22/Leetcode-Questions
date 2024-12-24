package Hard.FindMinimumDiameterAfterMergingTwoTrees;

import java.util.*;

/*
 * PROBLEM: 3203: Find Minimum Diameter After Merging Two Trees
 * 
 * There exist two undirected trees with n and m nodes, numbered from 0 to n - 1
 * and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1
 * and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai,
 * bi] indicates that there is an edge between nodes ai and bi in the first tree
 * and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and
 * vi in the second tree.
 * 
 * You must connect one node from the first tree with another node from the
 * second tree with an edge.
 * 
 * Return the minimum possible diameter of the resulting tree.
 * 
 * The diameter of a tree is the length of the longest path between any two
 * nodes in the tree.
 * 
 * Example 1:
 * Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
 * 
 * Output: 3
 * Explanation:
 * We can obtain a tree of diameter 3 by connecting node 0 from the first tree
 * with any node from the second tree.
 * 
 * Example 2:
 * Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 =
 * [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
 * 
 * Output: 5
 * Explanation:
 * We can obtain a tree of diameter 5 by connecting node 0 from the first tree
 * with node 0 from the second tree.
 */
class FindMinimumDiameterAfterMergingTwoTrees {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Step 01: Construct adjacency lists for Tree1 & Tree2.

        // No.of nodes in tree1.
        int n1 = edges1.length + 1;
        ArrayList<ArrayList<Integer>> tree1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            tree1.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            int u = edge[0];
            int v = edge[1];
            tree1.get(u).add(v);
            tree1.get(v).add(u);
        }
        // No.of nodes in tree2.
        int n2 = edges2.length + 1;
        ArrayList<ArrayList<Integer>> tree2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            tree2.add(new ArrayList<>());
        }

        for (int[] edge : edges2) {
            int u = edge[0];
            int v = edge[1];
            tree2.get(u).add(v);
            tree2.get(v).add(u);
        }

        // STEP 02: Calculate diameters of tree1 & tree2.
        int diameter1 = findDiameter(tree1, n1);
        int diameter2 = findDiameter(tree2, n2);

        // STEP 03: Calculate the merged tree's diameter.
        int totalDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

        // STEP 04: Return the maximum of the two diameters and the merged diameter.
        return Math.max(Math.max(diameter1, diameter2), totalDiameter);
    }

    // Method to find the diameter of a tree.
    int findDiameter(ArrayList<ArrayList<Integer>> tree, int n) {
        // First DFS to find the farthest node from any node.
        boolean[] visited1 = new boolean[n];
        // Stores farthest node & its distance.
        int[] result1 = new int[2];
        dfs(0, 0, tree, visited1, result1);

        // Second DFS from the farthest node found.
        int farthestNode = result1[0];
        boolean[] visited2 = new boolean[n];

        // Stores farthest distance.
        int[] result2 = new int[2];
        dfs(farthestNode, 0, tree, visited2, result2);

        // Return the farthest distance(diameter).
        return result2[1];
    }

    // Recursive DFS to find the farthest node and distance
    void dfs(int node, int distance, ArrayList<ArrayList<Integer>> tree, boolean[] visited, int[] result) {
        visited[node] = true;

        // Update the farthest distance and node if necessary
        if (distance > result[1]) {
            result[0] = node;
            result[1] = distance;
        }

        // Traverse all unvisited neighbors
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, distance + 1, tree, visited, result);
            }
        }
    }
}