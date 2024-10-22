/*
Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true
*/
import java.util.Scanner;
public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        long left = 0;
        long right = n / 2 + 1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long pow = (long) (Math.pow(4, mid));
            if (pow == ((long) n)) {
                return true;
            }
            if (pow > ((long) n)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of num(n): ");
        int n = input.nextInt();
        System.out.println("Power of four: "+isPowerOfFour(n));
    }
}