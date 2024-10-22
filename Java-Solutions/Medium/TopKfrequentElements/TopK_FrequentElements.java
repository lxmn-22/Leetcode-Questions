/*
Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]ff
*/
import java.util.*;
public class TopK_FrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, List<Integer>> frequencyToValueMap = new HashMap<>();
        for (Integer key : map.keySet()) {
            frequencyToValueMap.computeIfAbsent(map.get(key), j -> new ArrayList<>()).add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            List<Integer> values = frequencyToValueMap.getOrDefault(i, new ArrayList<>());
            if (result.size() + values.size() <= k) {
                result.addAll(values);
            } 
            else {
                int idx = 0;
                while (result.size() < k) {
                    result.add(values.get(idx++));
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println("Top K Frequent Elements: "+topKFrequent(nums,k));
    }
}