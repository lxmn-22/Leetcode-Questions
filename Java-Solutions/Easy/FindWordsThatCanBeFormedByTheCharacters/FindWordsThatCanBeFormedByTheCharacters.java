/*
You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars 
(each character can only be used once).
Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
*/
package Easy.FindWordsThatCanBeFormedByTheCharacters;

public class FindWordsThatCanBeFormedByTheCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> frequency = getFrequencyMap(chars);
        return Arrays.stream(words)
                .filter(word -> canBeFormed(word, frequency))
                .map(word -> word.length())
                .reduce(0, Integer::sum);
    }

    private boolean canBeFormed(String word, Map<Character, Integer> frequency) {
        Map<Character, Integer> wordFrequency = getFrequencyMap(word);
        for (Character key : wordFrequency.keySet()) {
            if (frequency.getOrDefault(key, 0) < wordFrequency.get(key)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getFrequencyMap(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }
}