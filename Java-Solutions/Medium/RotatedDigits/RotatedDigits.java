/*
An integer x is a good if after rotating each digit individually by 180 degrees, 
we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.
A number is valid if each digit remains a digit after rotation. 
For example:
0, 1, and 8 rotate to themselves,
2 and 5 rotate to each other (in this case they are rotated in a different direction, 
in other words, 2 or 5 gets mirrored), 6 and 9 rotate to each other, and
the rest of the numbers do not rotate to any other number and become invalid.
Given an integer n, return the number of good integers in the range [1, n].

Example 1:
Input: n = 10
Output: 4
Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.

Example 2:
Input: n = 1
Output: 0

Example 3:
Input: n = 2
Output: 1
*/
public class RotatedDigits {
    public static int rotatedDigits(int n) {
        int[] dp = new int[n + 1];
        int result = 0;
        for (int i = 0; i <= Math.min(n, 9); i++) {
            if (i == 0 || i == 1 || i == 8) {
                dp[i] = 1;
            } 
            else if (i == 2 || i == 5 || i == 6 || i == 9) {
                dp[i] = 2;
                result++;
            }
        }
        for (int i = 10; i <= n; i++) {
            int factor = dp[i / 10];
            int remainder = dp[i % 10];
            if (factor == 1 && remainder == 1) {
                dp[i] = 1;
            } 
            else if (factor >= 1 && remainder >= 1) {
                dp[i] = 2;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Rotated Digits: "+rotatedDigits(n));
    }
}