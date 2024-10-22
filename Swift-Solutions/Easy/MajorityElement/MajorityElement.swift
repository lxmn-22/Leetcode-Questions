/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/
class MajorityElement {
    func majorityElement(_ nums: [Int]) -> Int {
        // adding to dictionary num and num of apperance.
        var dict: [Int: Int] = [:]

        for num in nums {
            if let value = dict[num] {
                dict[num] = value + 1
            } else { 
                dict[num] = 1
            }
        }
        let half = nums.count / 2

        // for each dict by keys & check value > (n / 2) -> true.
        for key in dict.keys {
            if let value = dict[key], value > half {
                return key
            }
        }
        return 0
    }
}