/*
Given an integer array nums, your goal is to make all elements in nums equal. 
To complete one operation, follow these steps:

Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. 
If there are multiple elements with the largest value, pick the smallest i.
Find the next largest value in nums strictly smaller than largest. 
Let its value be nextLargest.
Reduce nums[i] to nextLargest.
Return the number of operations to make all elements in nums equal.

Example 1:
Input: nums = [5,1,3]
Output: 3
Explanation: It takes 3 operations to make all elements in nums equal:
1. largest = 5 at index 0. nextLargest = 3. Reduce nums[0] to 3. nums = [3,1,3].
2. largest = 3 at index 0. nextLargest = 1. Reduce nums[0] to 1. nums = [1,1,3].
3. largest = 3 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1].
 */
import java.util.*;

class ReductionOperationsToMakeTheArrayElementsEqual {
    public static int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<KeyEntry> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(KeyEntry k1, KeyEntry k2) {
                return k2.key - k1.key;
            }
        });
        for (Integer key : map.keySet()) {
            pq.add(new KeyEntry(key, map.get(key)));
        }
        int numOfSteps = 0;
        while (pq.size() > 1) {
            KeyEntry largest = pq.poll();
            KeyEntry secondLargest = pq.poll();
            secondLargest.val += largest.val;
            pq.add(secondLargest);
            numOfSteps += largest.val;
        }
        return numOfSteps;
    }
}

class KeyEntry {
    int key;
    int val;
  
    public KeyEntry(int key, int val) {
        this.key = key;
        this.val = val;
    }
}