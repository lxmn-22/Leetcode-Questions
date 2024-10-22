/* 
Given an integer n, return the number of trailing zeroes in n!.
Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Example 3:
Input: n = 0
Output: 0
*/
import java.util.Scanner;

class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 4) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();
        System.out.println("Number of zeroes: "+trailingZeroes(n));
    }
}