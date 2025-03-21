
/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 */

use std::collections::HashSet;

pub fn is_happy(mut n: i32) -> bool {
    let mut seen = HashSet::new();

    while n != 1 && seen.insert(n) {
        n = n
            .to_string()
            .chars()
            .map(|c| c.to_digit(10).unwrap().pow(2))
            .sum::<u32>() as i32;
    }

    n == 1
}

fn main() {
    let test = 19;
    let result = is_happy(test);
    println!("{:?}", result);
}
