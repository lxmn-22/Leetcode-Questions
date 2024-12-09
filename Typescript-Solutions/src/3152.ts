/*
 * PROBLEM: 3152: Special Array II
 * 
 * An array is considered special if every pair of its adjacent elements
 * contains two numbers with different parity.
 * 
 * You are given an array of integer nums and a 2D integer matrix queries, where
 * for queries[i] = [fromi, toi] your task is to check that
 * subarray
 * nums[fromi..toi] is special or not.
 * 
 * Return an array of booleans answer such that answer[i] is true if
 * nums[fromi..toi] is special.
 * 
 * Example 1:
 * Input: nums = [3,4,1,2,6], queries = [[0,4]]
 * Output: [false]
 * 
 * Explanation:
 * The subarray is [3,4,1,2,6]. 2 and 6 are both even.
 * 
 * Example 2:
 * Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]
 * Output: [false,true]
 * 
 * Explanation:
 * The subarray is [4,3,1]. 3 and 1 are both odd. So the answer to this query is
 * false.
 * The subarray is [1,6]. There is only one pair: (1,6) and it contains numbers
 * with different parity. So the answer to this query is true.
 */
function isArraySpecial(nums: number[], queries: number[][]): boolean[] {
    const prefixSum = [0];

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] % 2 !== nums[i - 1] % 2) {
            prefixSum.push(prefixSum[prefixSum.length - 1]);
        } else {
            prefixSum.push(prefixSum[prefixSum.length - 1] + 1);
        }
    }
    return queries.map(([from,to]) => prefixSum[from] === prefixSum[to]);
};