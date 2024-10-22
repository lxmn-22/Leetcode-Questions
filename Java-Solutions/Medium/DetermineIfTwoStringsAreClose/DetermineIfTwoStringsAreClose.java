/*
Two strings are considered close if you can attain one from the other using the following 
operations:
Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing 
character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, 
and false otherwise.

Example 1:
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:
Input: word1 = "a", word2 = "aa"
Output: false
 */
import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] frequencyOne = getFrequencyArray(word1);
        int[] frequencyTwo = getFrequencyArray(word2);
        for (int i = 0; i < frequencyOne.length; i++) {
            if (frequencyOne[i] == 0 && frequencyTwo[i] != 0) {
                return false;
            }
        }
        Arrays.sort(frequencyOne);
        Arrays.sort(frequencyTwo);
        for (int i = 0; i < frequencyOne.length; i++) {
            if (frequencyOne[i] != frequencyTwo[i]) {
                return false;
            }
        }
        return true;
    }
    private static int[] getFrequencyArray(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        return frequency;
    }
}