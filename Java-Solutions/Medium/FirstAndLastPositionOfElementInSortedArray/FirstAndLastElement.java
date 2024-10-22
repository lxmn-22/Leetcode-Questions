/*
Given an array of integers nums sorted in non-decreasing order, 
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FirstAndLastElement {
    private static enum Position {
        FIRST, LAST;
    }
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{
            search(nums, target, Position.FIRST),
            search(nums, target, Position.LAST)
        };
    }
    private static int search(int[] nums, int target, Position position) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (position == Position.FIRST) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println("First and Last position of element in sorted array: "+search(nums, target, null));
    }
}