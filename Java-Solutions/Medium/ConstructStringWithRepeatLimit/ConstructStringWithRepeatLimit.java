import java.util.*;

/*
 * PROBLEM: 2182: Construct String With Repeat Limit
 * 
 * You are given a string s and an integer repeatLimit. Construct a new string
 * repeatLimitedString using the characters of s such that no letter appears
 * more than repeatLimit times in a row. You do not have to use all characters
 * from s.
 * 
 * Return the lexicographically largest repeatLimitedString possible.
 * 
 * A string a is lexicographically larger than a string b if in the first
 * position where a and b differ, string a has a letter that appears later in
 * the alphabet than the corresponding letter in b. If the first min(a.length,
 * b.length) characters do not differ, then the longer string is the
 * lexicographically larger one.
 * 
 * Example 1:
 * Input: s = "cczazcc", repeatLimit = 3
 * Output: "zzcccac"
 * Explanation: We use all of the characters from s to construct the
 * repeatLimitedString "zzcccac".
 * The letter 'a' appears at most 1 time in a row.
 * The letter 'c' appears at most 3 times in a row.
 * The letter 'z' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string
 * is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so
 * we return "zzcccac".
 * Note that the string "zzcccca" is lexicographically larger but the letter 'c'
 * appears more than 3 times in a row, so it is not a valid repeatLimitedString.
 * 
 * Example 2:
 * Input: s = "aababab", repeatLimit = 2
 * Output: "bbabaa"
 * Explanation: We use only some of the characters from s to construct the
 * repeatLimitedString "bbabaa".
 * The letter 'a' appears at most 2 times in a row.
 * The letter 'b' appears at most 2 times in a row.
 * Hence, no letter appears more than repeatLimit times in a row and the string
 * is a valid repeatLimitedString.
 * The string is the lexicographically largest repeatLimitedString possible so
 * we return "bbabaa".
 * Note that the string "bbabaaa" is lexicographically larger but the letter 'a'
 * appears more than 2 times in a row, so it is not a valid repeatLimitedString.
 */
class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder result = new StringBuilder();

        int freq = 1;
        int pointer = chars.length - 1;

        for (int i = chars.length - 1; i >= 0; --i) {
            if (result.length() > 0 && result.charAt(result.length() - 1) == chars[i]) {
                if (freq < repeatLimit) {
                    result.append(chars[i]);
                    freq++;
                } else {
                    while (pointer >= 0 && (chars[pointer] == chars[i] || pointer > i)) {
                        pointer--;
                    }

                    if (pointer >= 0) {
                        result.append(chars[pointer]);
                        char temp = chars[i];
                        chars[i] = chars[pointer];
                        chars[pointer] = temp;
                        freq = 1;
                    } else {
                        break;
                    }
                }
            } else {
                result.append(chars[i]);
                freq = 1;
            }
        }
        return result.toString();
    }
}