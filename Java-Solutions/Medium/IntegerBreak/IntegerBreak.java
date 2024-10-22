/*
Given an integer n, break it into the sum of k positive integers, 
where k >= 2, and maximize the product of those integers.
Return the maximum product you can get.

Example 1:
Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
import java.util.*;
class IntegerBreak {
    public static int integerBreak(int n) {
        int[] result = new int[n + 1];
        result[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i/2; j ++) {
                int product = Math.max(result[j], j) * Math.max(result[i-j], i - j);
                max = Math.max(max, product);
            }
            result[i] = max;
        }
        return result[n];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number(n): ");
        int n = input.nextInt();
        System.out.println("Integer after addition and multiplication: "+integerBreak(n));
    }
}