/*
PROBLEM: 35: Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
*/
function searchInsert(nums: number[], target: number): number {
    let left = 0;
    let right = nums.length - 1;

    while(left <= right) {
        const mid = Math.floor((left + right) / 2);

        if(nums[mid] === target) {
            // target found at index mid.
            return mid;
        } else if(nums[mid] < target) {
            // adjust the left boundary.
            left = mid + 1;
        } else {
            // adjust the right boundary.
            right = mid - 1;
        }
    }
    return left;
};