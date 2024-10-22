/*
You are given an integer array nums. You are initially positioned at the array's first index, and 
each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
package Medium.JumpGame;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        // making the destination as the last index of the array.
        int destination = nums.length - 1;

        // iterating from the second last index.
        for (int i = nums.length - 2; i >= 0; i--) {

            // if the current index + the value at that index is greater or equal to the
            // destination,
            // then just change your destination to the index.
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }
        // if the final index reaches 0 that means we reached end of the array thus
        // function return true
        return destination == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println("Jump Game: " + canJump(nums));
    }
}