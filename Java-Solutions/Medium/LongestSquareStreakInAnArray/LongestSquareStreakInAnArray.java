package Medium.LongestSquareStreakInAnArray;

import java.util.*;

/*
 * PROBLEM: 2501 : Longest Square Streak in an Array.
 * 
 * You are given an integer array nums. A subsequence of nums is called a square
 * streak if:
 * 
 * The length of the subsequence is at least 2, and
 * after sorting the subsequence, each element (except the first element) is the
 * square of the previous number.
 * Return the length of the longest square streak in nums, or return -1 if there
 * is no square streak.
 * 
 * A subsequence is an array that can be derived from another array by deleting
 * some or no elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [4,3,6,16,8,2]
 * Output: 3
 * Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes
 * [2,4,16].
 * - 4 = 2 * 2.
 * - 16 = 4 * 4.
 * Therefore, [4,16,2] is a square streak.
 * It can be shown that every subsequence of length 4 is not a square streak.
 * 
 * Example 2:
 * Input: nums = [2,3,5,6,7]
 * Output: -1
 * Explanation: There is no square streak in nums so return -1.
 */
class LongestSquareStreakInAnArray {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        int result = -1;

        for (int num : nums) {
            int squareRoot = (int) Math.sqrt(num);

            if (squareRoot * squareRoot == num && map.containsKey(squareRoot)) {
                map.put(num, map.get(squareRoot) + 1);
                result = Math.max(result, map.get(num));
            } else {
                map.put(num, 1);
            }
        }
        return result;
    }
}