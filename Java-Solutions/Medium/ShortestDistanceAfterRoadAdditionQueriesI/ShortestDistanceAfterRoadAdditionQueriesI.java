package Medium.ShortestDistanceAfterRoadAdditionQueriesI;

import java.util.*;

/*
 * PROBLEM: 3243: Shortest Distance After Road Addition Queries I
 * 
 * You are given an integer n and a 2D integer array queries.
 * 
 * There are n cities numbered from 0 to n - 1. Initially, there is a
 * unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.
 * 
 * queries[i] = [ui, vi] represents the addition of a new unidirectional road
 * from city ui to city vi. After each query, you need to find the length of the
 * shortest path from city 0 to city n - 1.
 * 
 * Return an array answer where for each i in the range [0, queries.length - 1],
 * answer[i] is the length of the shortest path from city 0 to city n - 1 after
 * processing the first i + 1 queries.
 * 
 * Example 1:
 * Input: n = 5, queries = [[2,4],[0,2],[0,4]]
 * Output: [3,2,1]
 * 
 * Explanation:
 * After the addition of the road from 2 to 4, the length of the shortest path
 * from 0 to 4 is 3.
 * 
 * After the addition of the road from 0 to 2, the length of the shortest path
 * from 0 to 4 is 2.
 * 
 * After the addition of the road from 0 to 4, the length of the shortest path
 * from 0 to 4 is 1.
 * 
 * Example 2:
 * Input: n = 4, queries = [[0,3],[0,2]]
 * Output: [1,1]
 * 
 * Explanation:
 * After the addition of the road from 0 to 3, the length of the shortest path
 * from 0 to 3 is 1.
 * 
 * After the addition of the road from 0 to 2, the length of the shortest path
 * remains 1.
 */
class ShortestDistanceAfterRoadAdditionQueriesI {
    private void updateDistances(List<List<Integer>> graph, int current, int[] distances) {
        int newDist = distances[current] + 1;

        for (int neighbor : graph.get(current)) {
            if (distances[neighbor] <= newDist) {
                continue;
            }

            distances[neighbor] = newDist;
            updateDistances(graph, neighbor, distances);
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[n];
        for (int i = 0; i < n; ++i) {
            distances[i] = n - 1 - i;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i + 1 < n; ++i) {
            graph.get(i + 1).add(i);
        }

        int[] answer = new int[queries.length];
        int queryIdx = 0;

        for (int[] query : queries) {
            int source = query[0];
            int target = query[1];

            graph.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            updateDistances(graph, source, distances);

            answer[queryIdx++] = distances[0];
        }
        return answer;
    }
}