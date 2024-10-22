/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for (int i = 0; count < n; i++) {
            int currIdx = i;
            int prevValue = nums[i];
            do {
                int nextIdx = (currIdx + k) % n;
                int tempValue = nums[nextIdx];
                nums[nextIdx] = prevValue;
                prevValue = tempValue;
                currIdx = nextIdx;
                count++;
            } 
            while (i != currIdx);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("Rotated Array: ",rotate(nums, k));
    }
}