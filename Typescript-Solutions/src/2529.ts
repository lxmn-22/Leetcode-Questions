/*
PROBLEM: 2329: Maximum Count of Positive Integer and Negative Integer

Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.

Example 1:
Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

Example 2:
Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

Example 3:
Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
*/
function maximumCount(nums: number[]): number {
	const negCount = binarySearch(nums, 0);
	const posCount = nums.length - binarySearch(nums, 1);
	return Math.max(negCount, posCount);
}

function binarySearch(nums: number[], target: number): number {
	let left = 0,
		right = nums.length;
	while (left < right) {
		let mid = Math.floor((left + right) / 2);
		if (nums[mid] < target) left = mid + 1;
		else right = mid;
	}
	return left;
}
