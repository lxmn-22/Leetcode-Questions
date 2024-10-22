/*
Given two string arrays word1 and word2, return true if the two arrays represent the same string, 
and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
*/
package Easy.CheckIfTwoStringArraysAreEquivalent;

public class CheckIfTwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int wordIdxOne = 0;
        int wordIdxTwo = 0;
        int idxOne = 0;
        int idxTwo = 0;
        while (wordIdxOne < word1.length && wordIdxTwo < word2.length) {
            if (idxOne == word1[wordIdxOne].length() || idxTwo == word2[wordIdxTwo].length()) {
                if (idxOne == word1[wordIdxOne].length()) {
                    wordIdxOne++;
                    idxOne = 0;
                }
                if (idxTwo == word2[wordIdxTwo].length()) {
                    wordIdxTwo++;
                    idxTwo = 0;
                }
            } else {
                if (word1[wordIdxOne].charAt(idxOne) != word2[wordIdxTwo].charAt(idxTwo)) {
                    return false;
                }
                idxOne++;
                idxTwo++;
            }
        }
        return wordIdxOne == word1.length && wordIdxTwo == word2.length;
    }
}