/*
 * You are given a string s consisting only of the characters '0' and '1'. In
 * one operation,
 * you can change any '0' to '1' or vice versa.
 * The string is called alternating if no two adjacent characters are equal. For
 * example, the
 * string "010" is alternating, while the string "0100" is not.
 * Return the minimum number of operations needed to make s alternating.
 * 
 * Example 1:
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which
 * is alternating.
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public static int minOperations(String s) {
        int numOfChanges = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) {
                numOfChanges++;
            }
        }
        return Math.min(numOfChanges, s.length() - numOfChanges);
    }

    public static void main(String[] args) {
        String s = "0100";
        System.out.println("Minimum changes to make alternating binary string: " + minOperations(s));
    }
}