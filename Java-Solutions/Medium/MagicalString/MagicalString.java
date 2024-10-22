/*
A magical string s consists of only '1' and '2' and obeys the following rules:
The string s is magical because concatenating the number of contiguous occurrences of characters '1' and '2' 
generates the string s itself.
The first few elements of s is s = "1221121221221121122……". 
If we group the consecutive 1's and 2's in s, it will be "1 22 11 2 1 22 1 22 11 2 11 22 ......" and 
the occurrences of 1's or 2's in each group are "1 2 2 1 1 2 1 2 2 1 2 2 ......". 
You can see that the occurrence sequence is s itself.

Given an integer n, return the number of 1's in the first n number in the magical string s.

Example 1:
Input: n = 6
Output: 3
Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.

Example 2:
Input: n = 1
Output: 1
*/
public class MagicalString {
    public static int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] data = new int[100002];
        data[0] = 1;
        data[1] = 2;
        data[2] = 2;

        int i = 2, j = 2;
        int count = 1;
        int num = 1;
        while (i < n) {
            for (int k = 0; k < data[j]; k ++) {
                data[++i] = num;
                if (num == 1 && i < n) {
                    count ++;
                }
            }
            j ++;
            num = num ^ 3;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Magical String: "+magicalString(n));
    }
}
