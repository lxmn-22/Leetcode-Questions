package Medium.CountNicePairsInAnArray;

/*
You are given an array nums that consists of non-negative integers. Let us define rev(x) as 
the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. 
A pair of indices (i, j) is nice if it satisfies all of the following conditions:
0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, 
return it modulo 109 + 7.

Example 1:
Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
*/
import java.util.*;

class CountNicePairsInAnArray {
    public static int countNicePairs(int[] nums) {
        final int kMod = 1_000_000_007;
        long ans = 0;
        Map<Integer, Long> count = new HashMap<>();

        for (final int num : nums) {
            count.merge(num - rev(num), 1L, Long::sum);
        }
        for (final long freq : count.values()) {
            ans += freq * (freq - 1) / 2;
            ans %= kMod;
        }
        return (int) ans;
    }

    private static int rev(int n) {
        int x = 0;
        while (n > 0) {
            x = x * 10 + (n % 10);
            n /= 10;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = { 42, 11, 1, 97 };
        System.out.println("Count nice pairs in an array: " + countNicePairs(nums));

    }
}