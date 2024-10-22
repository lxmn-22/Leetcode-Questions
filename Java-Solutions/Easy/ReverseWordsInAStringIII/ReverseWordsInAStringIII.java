/*
Given a string s, reverse the order of characters in each word within a sentence while still 
preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"
 */
import java.util.Scanner;

public class ReverseWordsInAStringIII {
    public static String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        while (end < s.length()) {
            if (chars[end] == ' ') {
                if (start < end - 1) {
                    reverse(chars, start, end - 1);
                }
                end++;
                start = end;
            } else {
                end++;
            }
        }
        if (start < end) {
            reverse(chars, start, end - 1);
        }
        return String.valueOf(chars);
    }
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of string(s): ");
        String s = input.nextLine();
        System.out.println("Reverse Words: "+reverseWords(s));
    }
}