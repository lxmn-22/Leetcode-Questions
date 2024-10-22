/*
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities 
(this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 */
package Medium.ReorderRoutesToMakeAllPathsLeadToTheCityZero;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] conn : connections) {
            graph.computeIfAbsent(conn[0], k -> new ArrayList<>()).add(List.of(conn[1], 1));
            graph.computeIfAbsent(conn[1], k -> new ArrayList<>()).add(List.of(conn[0], 0));
        }
        int[] count = { 0 };
        bfs(0, n, graph, count);
        return count[0];
    }

    private static void bfs(int node, int n, Map<Integer, List<List<Integer>>> graph, int[] count) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (List<Integer> conn : graph.getOrDefault(removed, new ArrayList<>())) {
                int neighbor = conn.get(0);
                int direction = conn.get(1);
                if (!visited[neighbor]) {
                    count[0] += direction;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}