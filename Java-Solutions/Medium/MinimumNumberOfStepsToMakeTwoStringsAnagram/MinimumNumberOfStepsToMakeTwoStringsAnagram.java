/*
 * You are given two strings of the same length s and t. In one step you can
 * choose any character of t and replace it with another character.
 * Return the minimum number of steps to make t an anagram of s.
 * An Anagram of a string is a string that contains the same characters with a
 * different (or the same) ordering.
 * 
 * Example 1:
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of
 * s.
 * 
 * Example 2:
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters
 * to make t anagram of s.
 * 
 * Example 3:
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 */
class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public static int minSteps(String s, String t) {
        int[] count = new int[26];
        int i = 0;

        // Storing the difference of frequencies of characters in t and s.
        while (i < s.length()) {
            count[t.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
            i++;
        }

        int ans = 0;
        i = 0;

        while (i < 26) {
            ans += Math.max(0, count[i]);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "bab";
        String t = "aba";
        System.out.println("Minimum Steps: " + minSteps(s, t));
    }
}