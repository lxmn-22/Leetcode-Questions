/*
Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

Example 1:
Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99

Example 2:
Input: n = 0
Output: 1
*/
public class CountNumbersWithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if (n < 1) {
            return 1;
        }
        int nums = 10;
        int base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            nums += base;
        }
        return nums;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Unique Numbers: "+countNumbersWithUniqueDigits(n));
    }
}