/*
Given two integers left and right that represent the range [left, right], 
return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: left = 5, right = 7
Output: 4

Example 2:
Input: left = 0, right = 0
Output: 0

Example 3:
Input: left = 1, right = 2147483647
Output: 0
 */
/*
 * APPROACH
 * Binary Representation:

The binary representation of 5 is 101.
The binary representation of 7 is 111.
Identifying Common Prefix:

Start from the rightmost bit and compare each corresponding bit
of left and right.

The common prefix is 10.

Counting Shifts:

During the iteration, both left and right are right-shifted by 1 bit
 until they become equal.

The number of shifts required is 1.

Bitwise AND Calculation:

After finding the common prefix 10, the function left-shifts
 it by 1 bit.

The result is 100, which is the bitwise AND of all numbers
 in the range from 5 to 7.

So, for the input left = 5 and right = 7, the function 
returns 4 as the bitwise AND of all numbers in the range.
 */
package Medium.BitwiseANDofNumbersRange;

public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int left, int right) {
        int count = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return (left << count);
    }

    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println("Bitwise AND of numbers range: " + rangeBitwiseAnd(left, right));
    }
}