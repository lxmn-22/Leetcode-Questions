/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
import java.util.*;
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } 
            else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println("Contiguous Array: "+findMaxLength(nums));
    }
}