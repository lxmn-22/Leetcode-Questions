/*
 * Given an integer array nums, in which exactly two elements appear only once
 * and all the other elements appear exactly twice. Find the two elements that
 * appear only once. You can return the answer in any order.
 * 
 * You must write an algorithm that runs in linear runtime complexity and uses
 * only constant extra space.
 * 
 * Example 1:
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation: [5, 3] is also a valid answer.
 * 
 * Example 2:
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * 
 * Example 3:
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 * Constraints:
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */
class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[] { num1, num2 };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        System.out.println("Single number: " + singleNumber(nums));
    }
}