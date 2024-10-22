/*
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * 
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output
 * must not contain leading zeroes.
 * 
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 */
class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        // Stack to store the digits.
        Stack<Character> numStack = new Stack<>();

        // Iterating through each digit in the number.
        for (char digit : num.toCharArray()) {
            // While there are remaining removals (k) and the stack is not empty and the
            // current digit is smaller than the top of the stack.
            while (k > 0 && !numStack.isEmpty() && digit < numStack.peek()) {
                // Remove digits from the stack
                numStack.pop();
                k--;
            }
            // Push the current digit to the stack.
            numStack.push(digit);
        }
        // After iterating through the number, if there are still remaining removals,
        // remove digits from the stack
        while (k > 0 && !numStack.isEmpty()) {
            numStack.pop();
            k--;
        }
        // Construct the result string by popping digits from the stack.
        StringBuilder temp = new StringBuilder();
        while (!numStack.isEmpty()) {
            temp.append(numStack.pop());
        }
        // Reverse the result string to get the correct order.
        temp.reverse();

        // Remove leading zeros and construct the final result.
        int m = temp.length();
        StringBuilder result = new StringBuilder();
        int foundNonZero = 0;

        for (int i = 0; i < m; i++) {
            if (temp.charAt(i) == '0' && foundNonZero == 0) {
                continue;
            } else {
                result.append(temp.charAt(i));
                foundNonZero = 1;
            }
        }
        // If the result is empty, return "0"
        if (result.length() == 0)
            result.append('0');
        return result.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println("Remove K Digits: " + removeKdigits(num, k));
    }
}