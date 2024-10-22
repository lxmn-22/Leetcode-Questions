package Medium.MaximumWidthRamp;

import java.util.*;

/*
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i]
 * <= nums[j]. The width of such a ramp is j - i.
 * 
 * Given an integer array nums, return the maximum width of a ramp in nums. If
 * there is no ramp in nums, return 0.
 * 
 * Example 1:
 * Input: nums = [6,0,8,2,1,5]
 * Output: 4
 * Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] =
 * 0 and nums[5] = 5.
 * 
 * Example 2:
 * Input: nums = [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] =
 * 1 and nums[9] = 1.
 */
class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        Stack<Integer> s = new Stack<>();

        // Building a decreasing stack of indices.
        for (int i = 0; i < n; i++) {
            if (s.isEmpty() || nums[s.peek()] > nums[i]) {
                s.push(i);
            }
        }

        int maxWidth = 0;

        // Traverse from the end & find maximum width ramp.
        for (int j = n - 1; j >= 0; j--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - s.pop());
            }
        }
        return maxWidth;
    }
}