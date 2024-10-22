/*
Given two arrays nums1 and nums2.
Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
A subsequence of a array is a new array which is formed from the original array by deleting some 
(can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

Example 1:
Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.

Example 2:
Input: nums1 = [3,-2], nums2 = [2,-6,7]
Output: 21
Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.

Example 3:
Input: nums1 = [-1,-1], nums2 = [1,1]
Output: -1
Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.
*/
public class MaxDotProductOfTwoSubsequences {
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        for (int num : nums1) {
            maxOne = Math.max(maxOne, num);
            minOne = Math.min(minOne, num);
        }
        for (int num : nums2) {
            maxTwo = Math.max(maxTwo, num);
            minTwo = Math.min(minTwo, num);
        }
        if (maxOne < 0 && minTwo > 0) {
            return maxOne * minTwo;
        }
        if (minOne > 0 && maxTwo < 0) {
            return minOne * maxTwo;
        }
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int curr = nums1[i] * nums2[j] + dp[i + 1][j + 1];
                dp[i][j] = Math.max(curr, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};
        System.out.println("Max Dot Product: "+maxDotProduct(nums1,nums2));
    }
}