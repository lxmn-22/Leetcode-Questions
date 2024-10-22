/*
Given a string s and an integer k, return the maximum number of vowel letters in any 
substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
 */
package Medium.MaximumNumberOfVowelsInaSubstringOfAgivenLength;

public class MaximumNumberOfVowelsInaSubstringOfAgivenLength {
    public static int maxVowels(String s, int k) {
        int currCount = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < k - 1; i++) {
            if (vowels.contains(s.charAt(i))) {
                currCount++;
            }
        }
        int maxCount = 0;
        int start = 0;
        for (int i = k - 1; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currCount++;
            }
            maxCount = Math.max(maxCount, currCount);
            if (vowels.contains(s.charAt(start++))) {
                currCount--;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("Maximum Vowels: " + maxVowels(s, k));
    }
}