/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to 
be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
 */
class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
  
    private static int helper(int[] nums, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return startIdx;
        }
        int midIdx = (startIdx + endIdx) / 2;
        int nextToMid = midIdx + 1;
        if (nums[midIdx] > nums[nextToMid]) {
            return helper(nums, startIdx, midIdx);
        } else {
            return helper(nums, nextToMid, endIdx);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println("Peak element: "+findPeakElement(nums));
    }
}