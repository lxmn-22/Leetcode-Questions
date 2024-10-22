/*
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent. 
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
*/
import java.util.*;

class LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, String> DIGIT_TO_CHAR_MAPPING = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void letterCombinations(String digits, int idx, StringBuilder sb, List<String> result) {
        if (idx == digits.length()) {
            if (!sb.isEmpty()) {
                result.add(sb.toString());
            }
            return;
        }
        for (char c : DIGIT_TO_CHAR_MAPPING.get(digits.charAt(idx)).toCharArray()) {
            sb.append(c);
            letterCombinations(digits, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}