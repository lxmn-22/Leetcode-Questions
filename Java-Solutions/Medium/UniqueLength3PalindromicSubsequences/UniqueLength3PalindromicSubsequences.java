/*
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
Note that even if there are multiple ways to obtain the same subsequence, 
it is still only counted once.
A palindrome is a string that reads the same forwards and backwards.
A subsequence of a string is a new string generated from the original string with some characters 
(can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".

Example 1:
Input: s = "aabca"
Output: 3
*/
import java.util.*;

class UniqueLength3PalindromicSubsequences {
    public static int countPalindromicSubsequence(String s) {
        int ans = 0;
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, s.length());

        for (int i = 0; i < s.length(); ++i) {
            final int index = s.charAt(i) - 'a';
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }

        for (int i = 0; i < 26; ++i) {
            if (first[i] < last[i]) {
                ans += s.substring(first[i] + 1, last[i]).chars().distinct().count();
            }    
        }  
        return ans;
    }
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println("Unique length-3 palindromic subsequences: "+countPalindromicSubsequence(s));
    }
}
