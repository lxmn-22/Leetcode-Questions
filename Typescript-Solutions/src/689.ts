/*
PROBLEM: 689: Maximum Sum of 3 Non-Overlapping Subarrays

Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example 1:
Input: nums = [1,2,1,2,6,7,5,1], k = 2
Output: [0,3,5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.

Example 2:
Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
Output: [0,2,4]
*/
function maxSumOfThreeSubarrays(nums: number[], k: number): number[] {
    const n = nums.length;

    // Prefix sum array.
    const sumArray = new Array(n + 1).fill(0);

    for(let i = 0; i < n; i++) {
        sumArray[i + 1] = sumArray[i] + nums[i];
    }

    // best left subarray starting indices.
    const left = new Array(n).fill(0);
    // best right subarray starting indices.
    const right = new Array(n).fill(0);
    // result to store final indices.
    const result = [0, 0, 0];

    // Compute left array.
    let maxLeftIndex = 0;

    for(let i = k - 1; i < n; i++) {
        if(sumArray[i + 1] - sumArray[i + 1 - k] > sumArray[maxLeftIndex + k] - sumArray[maxLeftIndex]) {
            maxLeftIndex = i + 1 - k;
        }
        left[i] = maxLeftIndex;
    }

    // Compute right array.
    let maxRightIndex = n - k;

    for(let i = n - k; i >= 0; i--) {
        if(sumArray[i + k] -sumArray[i] >= sumArray[maxRightIndex + k] - sumArray[maxRightIndex]) {
            maxRightIndex = i;
        }
        right[i] = maxRightIndex;
    }

    // find the maximum sum for the three subarrays.
    let maxSum = 0;

    for(let i = k; i <= n -2 * k; i++) {
        const l = left[i - 1];
        const r = right[i + k];
        const totalSum = 
            (sumArray[l + k] - sumArray[l]) + 
            (sumArray[i + k] - sumArray[i]) + 
            (sumArray[r + k] - sumArray[r]);
        
        if(totalSum > maxSum) {
            maxSum = totalSum;
            result[0] = l;
            result[1] = i;
            result[2] = r;
        }
    }
    return result;
};