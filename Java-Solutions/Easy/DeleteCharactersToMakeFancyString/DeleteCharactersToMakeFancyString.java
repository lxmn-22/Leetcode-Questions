
/*
 * PROBLEM: 1957: Delete Characters to make fancy string.
 * 
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:
Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:
Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:
Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 */
class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        int n = s.length();
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == sb.charAt(sb.length() - 1)) {
                count++;
                if (count < 3) {
                    sb.append(s.charAt(i));
                }
            } else {
                count = 1;
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

/*
 * ============================================================================
 */
// More optimized approach.
class DeleteCharactersToMakeFancyString2 {
    public String makeFancyString(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char previous = s.charAt(0);

        for (char current : s.toCharArray()) {
            if (current == previous) {
                sameCount++;
            } else {
                sameCount = 1;
            }
            if (sameCount < 3)
                sb.append(current);
            previous = current;
        }
        return sb.toString();
    }
}