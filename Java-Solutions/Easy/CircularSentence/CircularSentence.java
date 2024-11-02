package Easy.CircularSentence;

/*
 * PROBLEM: 2490: Circular Sentence
 * 
 * A sentence is a list of words that are separated by a single space with no
 * leading or trailing spaces.
 * 
 * For example, "Hello World", "HELLO", "hello world hello world" are all
 * sentences.
 * Words consist of only uppercase and lowercase English letters. Uppercase and
 * lowercase English letters are considered different.
 * 
 * A sentence is circular if:
 * The last character of a word is equal to the first character of the next
 * word.
 * The last character of the last word is equal to the first character of the
 * first word.
 * For example, "leetcode exercises sound delightful", "eetcode",
 * "leetcode eats soul" are all circular sentences. However, "Leetcode is cool",
 * "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular
 * sentences.
 * 
 * Given a string sentence, return true if it is circular. Otherwise, return
 * false.
 * 
 * Example 1:
 * Input: sentence = "leetcode exercises sound delightful"
 * Output: true
 * Explanation: The words in sentence are ["leetcode", "exercises", "sound",
 * "delightful"].
 * - leetcode's last character is equal to exercises's first character.
 * - exercises's last character is equal to sound's first character.
 * - sound's last character is equal to delightful's first character.
 * - delightful's last character is equal to leetcode's first character.
 * The sentence is circular.
 * 
 * Example 2:
 * Input: sentence = "eetcode"
 * Output: true
 * Explanation: The words in sentence are ["eetcode"].
 * - eetcode's last character is equal to eetcode's first character.
 * The sentence is circular.
 * 
 * Example 3:
 * Input: sentence = "Leetcode is cool"
 * Output: false
 * Explanation: The words in sentence are ["Leetcode", "is", "cool"].
 * - Leetcode's last character is not equal to is's first character.
 * The sentence is not circular.
 */
class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        int n = words.length;

        for (int i = 0; i < n - 1; i++) {
            char lastCharOfCurrentWord = words[i].charAt(words[i].length() - 1);
            char firstCharOfNextWord = words[i + 1].charAt(0);

            if (lastCharOfCurrentWord != firstCharOfNextWord) {
                return false;
            }
        }
        char lastCharOfLastWord = words[n - 1].charAt(words[n - 1].length() - 1);
        char firstCharOfFirstWord = words[0].charAt(0);

        return lastCharOfLastWord == firstCharOfFirstWord;
    }
}