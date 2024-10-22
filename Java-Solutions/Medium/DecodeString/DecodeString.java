package Medium.DecodeString;

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square 
brackets is being repeated exactly k times. Note that k is guaranteed to be a positive 
integer.
You may assume that the input string is always valid; there are no extra white spaces, 
square brackets are well-formed, etc. Furthermore, you may assume that the original 
data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
*/
import java.util.*;

class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String temp = sb.toString();
                sb.setLength(0);
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.append(stack.pop());
                }
                int count = Integer.parseInt(sb.reverse().toString());
                while (count-- > 0) {
                    for (int i = temp.length() - 1; i >= 0; i--) {
                        stack.push(temp.charAt(i));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println("Decode String: "+decodeString(s));
    }
}