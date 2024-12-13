package Medium.FIndScoreOfAnArrayAfterMarkingAllElements;

import java.util.*;

/*
 * PROBLEM: 2593: Find Score of an Array After Marking All Elements
 * 
 * You are given an array nums consisting of positive integers.
 * 
 * Starting with score = 0, apply the following algorithm:
 * 
 * Choose the smallest integer of the array that is not marked. If there is a
 * tie, choose the one with the smallest index.
 * Add the value of the chosen integer to score.
 * Mark the chosen element and its two adjacent elements if they exist.
 * Repeat until all the array elements are marked.
 * Return the score you get after applying the above algorithm.
 * 
 * Example 1:
 * Input: nums = [2,1,3,4,5,2]
 * Output: 7
 * Explanation: We mark the elements as follows:
 * - 1 is the smallest unmarked element, so we mark it and its two adjacent
 * elements: [2,1,3,4,5,2].
 * - 2 is the smallest unmarked element, so we mark it and its left adjacent
 * element: [2,1,3,4,5,2].
 * - 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
 * Our score is 1 + 2 + 4 = 7.
 * 
 * Example 2:
 * Input: nums = [2,3,5,1,3,2]
 * Output: 5
 * Explanation: We mark the elements as follows:
 * - 1 is the smallest unmarked element, so we mark it and its two adjacent
 * elements: [2,3,5,1,3,2].
 * - 2 is the smallest unmarked element, since there are two of them, we choose
 * the left-most one, so we mark the one at index 0 and its right adjacent
 * element: [2,3,5,1,3,2].
 * - 2 is the only remaining unmarked element, so we mark it: [2,3,5,1,3,2].
 * Our score is 1 + 2 + 2 = 5.
 */
class FIndScoreOfAnArrayAfterMarkingAllElements {
    public long findScore(int[] nums) {
        int n = nums.length;

        // Create a list of pairs (value, index).
        List<int[]> sortedNums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sortedNums.add(new int[] { nums[i], i });
        }

        // Sort the list based on the value in each pair.
        Collections.sort(sortedNums, (a, b) -> Integer.compare(a[0], b[0]));

        // Use long to avoid overflow.
        long score = 0;

        // Iterate through the sorted array.
        for (int i = 0; i < n; i++) {
            int num = sortedNums.get(i)[0];
            int index = sortedNums.get(i)[1];

            // Process only if not already marked.
            if (nums[index] != -1) {
                // Add the value to the score.
                score += num;
                // Mark the current index as processed.
                nums[index] = -1;
                if (index > 0) {
                    // Mark the left neighbor as processed.
                    nums[index - 1] = -1;
                }
                if (index < n - 1) {
                    // Mark the right neighbor as processed.
                    nums[index + 1] = -1;
                }
            }
        }
        return score;
    }
}