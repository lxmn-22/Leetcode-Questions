/*
 * A message containing letters from A-Z can be encoded into numbers using the
 * following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back
 * into letters
 * using the reverse of the mapping above (there may be multiple ways). For
 * example, "11106" can
 * be mapped into:
 * 
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped
 * into 'F' since "6"
 * is different from "06".
 * 
 * Given a string s containing only digits, return the number of ways to decode
 * it.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * 
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 */
class DecodingWays {
    public static int numDecodings(String s) {
        final int n = s.length();
        // dp[i] := the number of ways to decode s[i..n)
        int[] dp = new int[n + 1];
        dp[n] = 1; // ""
        dp[n - 1] = isValid(s.charAt(n - 1)) ? 1 : 0;

        for (int i = n - 2; i >= 0; --i) {
            if (isValid(s.charAt(i)))
                dp[i] += dp[i + 1];
            if (isValid(s.charAt(i), s.charAt(i + 1)))
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }

    private static boolean isValid(char c) {
        return c != '0';
    }

    private static boolean isValid(char c1, char c2) {
        return c1 == '1' || c1 == '2' && c2 < '7';
    }
}