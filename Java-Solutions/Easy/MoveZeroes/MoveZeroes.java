/*
Given an integer array nums, move all 0's to the end of it while maintaining the 
relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
*/
class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < nums.length) {
            if (nums[endIdx] != 0) {
                nums[startIdx++] = nums[endIdx];
            }
        endIdx++;
        }
        while (startIdx < nums.length) {
            nums[startIdx++] = 0;
        }
    }
}