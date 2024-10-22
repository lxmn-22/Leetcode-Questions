/*
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * 
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * 
 * Example 3:
 * Input: n = 3
 * Output: false
 */

/* Approach:
1. If n is divisible by 2, every time we'll encounter 1 at the end.
2. And at any point if n isn't divisible by 2, we'll return false.
*/

class PowersOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                break;
            }
            n /= 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println("Powers of Two: " + isPowerOfTwo(n));
    }
}