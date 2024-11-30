package Hard.ValidArrangementOfPairs;

import java.util.*;

/*
 * PROBLEM: 2097: Valid Arrangement of Pairs
 * 
 * You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti,
 * endi]. An arrangement of pairs is valid if for every index i where 1 <= i <
 * pairs.length, we have endi-1 == starti.
 * 
 * Return any valid arrangement of pairs.
 * 
 * Note: The inputs will be generated such that there exists a valid arrangement
 * of pairs.
 * 
 * Example 1:
 * Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
 * Output: [[11,9],[9,4],[4,5],[5,1]]
 * Explanation:
 * This is a valid arrangement since endi-1 always equals starti.
 * end0 = 9 == 9 = start1
 * end1 = 4 == 4 = start2
 * end2 = 5 == 5 = start3
 * 
 * Example 2:
 * Input: pairs = [[1,3],[3,2],[2,1]]
 * Output: [[1,3],[3,2],[2,1]]
 * Explanation:
 * This is a valid arrangement since endi-1 always equals starti.
 * end0 = 3 == 3 = start1
 * end1 = 2 == 2 = start2
 * The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
 * 
 * Example 3:
 * Input: pairs = [[1,2],[1,3],[2,1]]
 * Output: [[1,2],[2,1],[1,3]]
 * Explanation:
 * This is a valid arrangement since endi-1 always equals starti.
 * end0 = 2 == 2 = start1
 * end1 = 1 == 1 = start2
 */
class ValidArrangementOfPairs {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> inOutDegree = new HashMap<>();

        // Build graph and count in/out degrees
        for (int[] pair : pairs) {
            adjacencyList.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            inOutDegree.merge(pair[0], 1, Integer::sum); // out-degree
            inOutDegree.merge(pair[1], -1, Integer::sum); // in-degree
        }

        // Find starting node
        int startNode = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : inOutDegree.entrySet()) {
            if (entry.getValue() == 1) {
                startNode = entry.getKey();
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        Deque<Integer> nodeStack = new ArrayDeque<>();
        nodeStack.push(startNode);

        while (!nodeStack.isEmpty()) {
            List<Integer> neighbors = adjacencyList.getOrDefault(nodeStack.peek(), new ArrayList<>());
            if (neighbors.isEmpty()) {
                path.add(nodeStack.pop());
            } else {
                int nextNode = neighbors.get(neighbors.size() - 1);
                nodeStack.push(nextNode);
                neighbors.remove(neighbors.size() - 1);
            }
        }

        int pathSize = path.size();
        int[][] arrangement = new int[pathSize - 1][2];

        for (int i = pathSize - 1; i > 0; --i) {
            arrangement[pathSize - 1 - i] = new int[] { path.get(i), path.get(i - 1) };
        }
        return arrangement;
    }
}