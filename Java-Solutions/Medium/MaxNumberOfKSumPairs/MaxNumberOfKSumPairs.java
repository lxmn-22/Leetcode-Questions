/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them
from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
*/
import java.util.*;

class MaxNumberOfKSumPairs {
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                count++;
                map.put(k - num, map.getOrDefault(k - num, 0) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 5;
        System.out.println("Max Number of K-sum pairs: "+maxOperations(nums, k));
    }
}