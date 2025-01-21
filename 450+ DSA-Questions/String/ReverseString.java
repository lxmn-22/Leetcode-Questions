/*
 * PROBLEM: LEETCODE-344: Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
    // BRUTE-FORCE: function to reverse char of arr.
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = { 'L', 'a', 'x', 'm', 'a', 'n' };
        int n = s.length;

        System.out.print("Array before reversal of string: ");
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();

        reverseString(s);

        System.out.print("Array before reversal of string: ");
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
}
