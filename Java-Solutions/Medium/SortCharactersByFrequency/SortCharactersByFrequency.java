/*
Given a string s, sort it in decreasing order based on the frequency of the characters. 
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
*/
import java.util.*;
public class SortCharactersByFrequency {
    private static final String ALL_LETTERS = 
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
        }
        List<Character>[] frequencyToChar = new List[maxFrequency + 1];
        for (char c : map.keySet()) {
            if (frequencyToChar[map.get(c)] == null) {
                frequencyToChar[map.get(c)] = new ArrayList<>();
            }
            frequencyToChar[map.get(c)].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFrequency; i > 0; i--) {
            List<Character> characters = frequencyToChar[i] == null ? 
                new ArrayList<>() : frequencyToChar[i];
            for (char c : characters) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Frequency Sort: "+frequencySort(s));
    }
}