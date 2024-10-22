/* Write a function that takes the binary representation of an unsigned integer 
and returns the number of '1' bits it has (also known as the Hamming weight).

Note:
In some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type.
It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. 
Therefore, in Example 3, the input represents the signed integer. -3.
 */

public class NumberOf1Bits {
      // you need to treat n as an unsigned value
      public static int hammingWeight(int n) {
            int bits = 0;
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                  if ((n & mask) != 0) {
                        bits++;
                  }
                  mask <<= 1;
            }
      return bits;
      }
      public static void main(String[] args) {
            int n = 00000000000000000000000000001011;
            System.out.println("Number of 1 Bits: "+hammingWeight(n));
      }
}