/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int[] palindromeCount = {0};
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i, palindromeCount);
            checkPalindrome(s, i, i + 1, palindromeCount);
        }    
        return palindromeCount[0];
    }
    private static void checkPalindrome(String s, int leftIdx, int rightIdx, int[] palindromeCount) {
        while (leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {
            palindromeCount[0]++;
            leftIdx--;
            rightIdx++;
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Palindromic Substrings: "+countSubstrings(s));
    }
}