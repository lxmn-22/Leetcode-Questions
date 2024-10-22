/*
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * 
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */
class MinimumRemoveToMakeValidParenthesis {
    public static String minRemoveToMakeValid(String s) {
        // Initialize pointers for the start and end of the string.
        int startPointer = 0;
        int endPointer = s.length() - 1;

        String result;

        // Convert input string to character array for easier manipulation.
        char[] arr = s.toCharArray();

        // Counter for open parentheses
        int openParenthesesCount = 0;

        // First pass: mark excess closing parentheses with '*'.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                openParenthesesCount++;
            } else if (arr[i] == ')') {
                if (openParenthesesCount == 0) {
                    // Mark excess closing parentheses.
                    arr[i] = '*';
                } else {
                    openParenthesesCount--;
                }
            }
        }

        // Second pass: mark excess opening parentheses from the end.
        for (int i = arr.length - 1; i >= 0; i--) {
            if (openParenthesesCount > 0 && arr[i] == '(') {
                // Mark excess opening parentheses.
                arr[i] = '*';
                openParenthesesCount--;
            }
        }

        // Filter out marked characters and store the result in the character array.
        // Pointer for updating the character array.
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                arr[p++] = arr[i];
            }
        }

        // Construct the result string from the filtered character array.
        result = new String(arr).substring(0, p);

        return result;
    }
}