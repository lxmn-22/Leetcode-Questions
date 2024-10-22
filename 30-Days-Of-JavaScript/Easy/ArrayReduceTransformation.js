/*
Given an integer array nums, a reducer function fn, and an initial value init, 
return a reduced array.

A reduced array is created by applying the following operation: val = fn(init, nums[0]), 
val = fn(val, nums[1]), val = fn(val, nums[2]), ...until every element in the array has been processed. The final value of val is returned.

If the length of the array is 0, it should return init.
Please solve it without using the built-in Array.reduce method.

Example 1:
Input: 
nums = [1,2,3,4]
fn = function sum(accum, curr) { return accum + curr; }
init = 0
Output: 10
Explanation:
initially, the value is init=0.
(0) + nums[0] = 1
(1) + nums[1] = 3
(3) + nums[2] = 6
(6) + nums[3] = 10
The final answer is 10.
*/
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    for(var i=0; i<nums.length; i++){
        init = fn(init, nums[i]);
    }
    return init;
};