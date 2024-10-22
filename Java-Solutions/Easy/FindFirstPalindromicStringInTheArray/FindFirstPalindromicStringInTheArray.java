/*
 * Given an array of strings words, return the first palindromic string in the
 * array. If there is no such string, return an empty string "".
 * 
 * A string is palindromic if it reads the same forward and backward.
 *
 * Example 1:
 * Input: words = ["abc","car","ada","racecar","cool"]
 * Output: "ada"
 * Explanation: The first string that is palindromic is "ada".
 * Note that "racecar" is also palindromic, but it is not the first.
 */
public class FindFirstPalindromicStringInTheArray {
    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            if (word.equals(reversed.toString())) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println("First palindromic string in the array: " + firstPalindrome(words));
    }
}