/*
There is an integer array nums that consists of n unique elements, but you have forgotten it. 
However, you do remember every pair of adjacent elements in nums.
You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates 
that the elements ui and vi are adjacent in nums.
It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, 
either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
Return the original array nums. If there are multiple solutions, return any of them.

Example 1:
Input: adjacentPairs = [[2,1],[3,4],[3,2]]
Output: [1,2,3,4]
Explanation: This array has all its adjacent pairs in adjacentPairs.
Notice that adjacentPairs[i] may not be in left-to-right order.

Example 2:
Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
Output: [-2,4,1,-3]
Explanation: There can be negative numbers.
Another solution is [-3,1,4,-2], which would also be accepted.
*/

import java.util.*;
class RestoreTheArrayFromAdjacentPairs {
    public static int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int firstElement = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
        queue.add(firstElement);
        Set<Integer> set = new HashSet<>();
        int[] result = new int[n];
        int idx = 0;
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            if (set.contains(removed)) {
                continue;
            }
            result[idx++] = removed;
            set.add(removed);
            queue.addAll(map.get(removed));
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        System.out.println("Restore the array from adjacent pairs: "+restoreArray(adjacentPairs));
    }
}