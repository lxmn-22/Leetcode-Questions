/*
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

Example 1:
Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: 
[1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].

Example 2:
Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
 */
class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static long countSubarrays(int[] nums, int k) {
        long maxNum = Long.MIN_VALUE;
        int count = 0;
        long left = 0;
        int right = 0;
        int ans = 0;

        // Find the maximum element in the array.
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        while (right < nums.length || left > right) {
            if (nums[(int) right] == maxNum) {
                count++;
            }
            // If count is greater than or equal to k, calculate subarrays count.
            while (count >= k) {
                if (nums[(int) left] == maxNum) {
                    count--;
                }
                left++;
                ans += nums.length - right;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println("Count subarrays where max element appears at least K times: " + countSubarrays(nums, k));
    }
}