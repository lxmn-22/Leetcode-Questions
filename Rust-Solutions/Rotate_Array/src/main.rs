
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

pub fn max_profit(k: i32, prices: Vec<i32>) -> i32 {
    let n = nums.len();
    let k = (k as usize) % n; 

    nums.reverse(); 
    nums[..k].reverse(); 
    nums[k..].reverse();
}

fn main() {
    let test = vec![1,2,3,4,5,6,7];
    let result = rotate(&mut test, 3);
    println!("{:?}", result);
}