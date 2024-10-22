/*
Given an integer array nums where every element appears three times except for one, 
which appears exactly once. Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/
public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        int[] nums1 = {0,1,0,1,0,1,99};
        System.out.println("Single Number present in array: "+singleNumber(nums));
        System.out.println("Single Number present in array: "+singleNumber(nums1));
    }
}