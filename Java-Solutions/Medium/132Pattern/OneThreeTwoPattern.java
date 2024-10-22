/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], 
nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.

Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
*/
import java.util.*;
public class OneThreeTwoPattern {
    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] minTillIndex = new int[nums.length];
        minTillIndex[0] = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            minTillIndex[idx] = Math.min(minTillIndex[idx - 1], nums[idx]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            if (nums[idx] > minTillIndex[idx]) {
                while (!stack.isEmpty() && stack.peek() <= minTillIndex[idx]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[idx]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println("132 Pattern: "+find132pattern(nums));
    }
}