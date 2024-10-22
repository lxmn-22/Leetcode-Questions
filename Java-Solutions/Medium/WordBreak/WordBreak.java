/*
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as
 * "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 */
class WordBreak {
    private static int[] dp;

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();

        for (String g : wordDict) {
            set.add(g);
        }
        dp = new int[300];
        Arrays.fill(dp, -1);

        return solve(set, s.toCharArray(), 0) == 1 ? true : false;
    }

    private static int solve(Set<String> set, char[] s, int ptr) {
        if (ptr == s.length) {
            return 1;
        }
        if (dp[ptr] != -1) {
            return dp[ptr];
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = ptr; i < s.length; i++) {
            sb.append(String.valueOf(s[i]));

            if (set.contains(sb.toString())) {
                if (solve(set, s, i + 1) == 1) {
                    return dp[i] = 1;
                }
            }
        }
        return dp[ptr] = 0;
    }
}