/*
 * PROBLEM: 862: Shortest Subarray with Sum at Least K
 * 
 * Given an integer array nums and an integer k, return the length of the
 * shortest non-empty subarray of nums with a sum of at least k. If there is no
 * such subarray, return -1.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * Input: nums = [1], k = 1
 * Output: 1
 * 
 * Example 2:
 * Input: nums = [1,2], k = 4
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [2,-1,2], k = 3
 * Output: 3
 */
function shortestSubarray(nums: number[], k: number): number {
    const n: number = nums.length;
    const sum: number[] = new Array(n + 1).fill(0);

    for(let i = 0; i < n; i++) {
        sum[i + 1] = sum[i] + nums[i];
    }

    const q: number[] = new Array(n + 1).fill(0);
    let l: number = 0;
    let r: number = 0;
    let minLength: number = n + 1;

    for(let i = 0; i < sum.length; i++) {
        while(r > l && sum[i] >= sum[q[l]] + k) {
            minLength = Math.min(minLength, i - q[l]);
            l++;
        }
        while(r > l && sum[i] <= sum[q[r - 1]]) {
            r--;
        }
        q[r] = i;
        r++;
    }
    return minLength <= n ? minLength : -1;
};