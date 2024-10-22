package Medium.MaximalScoreAfterApplyingKOperations;

import java.util.*;

/*
 * PROBLEM: 2530
 * 
 * You are given a 0-indexed integer array nums and an integer k. You have a
 * starting score of 0.
 * 
 * In one operation:
 * 
 * choose an index i such that 0 <= i < nums.length,
 * increase your score by nums[i], and
 * replace nums[i] with ceil(nums[i] / 3).
 * Return the maximum possible score you can attain after applying exactly k
 * operations.
 * 
 * The ceiling function ceil(val) is the least integer greater than or equal to
 * val.
 * 
 * Example 1:
 * Input: nums = [10,10,10,10,10], k = 5
 * Output: 50
 * Explanation: Apply the operation to each array element exactly once. The
 * final score is 10 + 10 + 10 + 10 + 10 = 50.
 * 
 * Example 2:
 * Input: nums = [1,10,3,3,3], k = 3
 * Output: 17
 * Explanation: You can do the following operations:
 * Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases
 * by 10.
 * Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases
 * by 4.
 * Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases
 * by 3.
 * The final score is 10 + 4 + 3 = 17.
 */
class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i : nums) {
            pq.add(i);
        }

        long ans = 0;

        while (k-- > 0) {
            int n = pq.poll();
            ans += n;
            pq.offer((n + 2) / 3);
        }
        return ans;
    }
}