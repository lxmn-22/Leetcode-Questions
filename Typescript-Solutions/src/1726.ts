/*
PROBLEM: 1726: Tuple with Same Product

Given an array nums of distinct positive integers, return the number of tuples 
(a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and
a != b != c != d.

Example 1:
Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

Example 2:
Input: nums = [1,2,4,5,10]
Output: 16
Explanation: There are 16 valid tuples:
(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
*/
function tupleSameProduct(nums: number[]): number {
	const m = new Map<number, number>();
	const n = nums.length;
	let result = 0;

	for (let i = 0; i < n; i += 1) {
		for (let j = i + 1; j < n; j += 1) {
			const current = nums[i] * nums[j];
			const count = m.get(current) || 0;
			if (count >= 1) {
				result += count;
			}
			m.set(current, count + 1);
		}
	}
	return result * 8;
}
