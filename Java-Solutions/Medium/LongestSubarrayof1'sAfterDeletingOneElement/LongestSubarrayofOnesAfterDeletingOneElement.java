/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. 
Return 0 if there is no such subarray.

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] 
contains 3 numbers with value of 1's.
 */
package Medium.LongestSubarrayofOnesAfterDeletingOneElement;

public class LongestSubarrayofOnesAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int zeroIdx = -1;
        int windowSize = 0;
        int startIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startIdx = zeroIdx + 1;
                zeroIdx = i;
            }
            windowSize = Math.max(windowSize, i - startIdx);
        }
        return windowSize;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1 };
        System.out.println("Longest Subarray: " + longestSubarray(nums));
    }
}