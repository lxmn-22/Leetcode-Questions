/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected 
directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and 
isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
 */
package Medium.NumberOfProvinces;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    graph.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                traverse(graph, i, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private static void traverse(Map<Integer, Set<Integer>> graph, int city, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        visited.add(city);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer conn : graph.getOrDefault(removed, new HashSet<>())) {
                if (!visited.contains(conn)) {
                    queue.add(conn);
                    visited.add(conn);
                }
            }
        }
    }
}