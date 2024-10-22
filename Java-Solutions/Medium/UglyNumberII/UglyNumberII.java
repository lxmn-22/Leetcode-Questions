/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.

Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Example 2:
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
*/
public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int mul2 = 2;
        int mul3 = 3;
        int mul5 = 5;
        int ugly = arr[0];
        for (int i = 1; i < n; i++) {
            ugly = Math.min(mul2, Math.min(mul3, mul5));
            arr[i] = ugly;
            if (ugly == mul2) {
                idx2++;
                mul2 = arr[idx2] * 2;
            }
            if (ugly == mul3) {
                idx3++;
                mul3 = arr[idx3] * 3;
            }
            if (ugly == mul5) {
                idx5++;
                mul5 = arr[idx5] * 5;
            }
        }
        return ugly;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Ugly Number: "+nthUglyNumber(n));
    }
}