/*
 * Given a string s of zeros and ones, return the maximum score after splitting
 * the string into two non-empty substrings
 * (i.e. left substring and right substring).
 * 
 * The score after splitting a string is the number of zeros in the left
 * substring plus the number of ones in the right substring.
 * 
 * Example 1:
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 */
class MaximumScoreAfterSplittingString {
    public static int maxScore(String s) {
        int ans = 0;
        int zeros = 0;
        int ones = (int) s.chars().filter(c -> c == '1').count();

        for (int i = 0; i + 1 < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zeros;
            } else {
                --ones;
            }
            ans = Math.max(ans, zeros + ones);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "011101";
        System.out.println("Maximum score after splitting string: " + maxScore(s));
    }
}