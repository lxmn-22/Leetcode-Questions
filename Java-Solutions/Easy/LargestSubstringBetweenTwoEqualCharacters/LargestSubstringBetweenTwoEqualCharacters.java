/*
 * Given a string s, return the length of the longest substring between two
 * equal characters,
 * excluding the two characters. If there is no such substring return -1.
 * A substring is a contiguous sequence of characters within a string.
 * 
 * Example 1:
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two
 * 'a's.
 */
class LargestSubstringBetweenTwoEqualCharacters {
    public static int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans = Math.max(ans, right - left - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println("Largest substring between two equal characters: " + maxLengthBetweenEqualCharacters(s));
    }
}