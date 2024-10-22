/*
 * Given a binary array nums and an integer goal, return the number of non-empty
 * subarrays with a sum goal.
 * 
 * A subarray is a contiguous part of the array.
 * 
 * Example 1:
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 
 * Example 2:
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 */
class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0;
        int count = 0;
        int res = 0;

        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == 1) {
                goal--;
                count = 0;
            }

            while (goal == 0 && i <= j) {
                goal += nums[i];
                i++;
                count++;
                if (i > j - goal + 1) {
                    break;
                }
            }

            while (goal < 0) {
                goal += nums[i];
                i++;
            }
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println("Binary Subarrays with sum: " + numSubarraysWithSum(nums, goal));
    }
}