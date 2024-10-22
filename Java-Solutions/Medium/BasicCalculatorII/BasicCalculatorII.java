/*
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. 
All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, 
such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
*/
public class BasicCalculatorII {
    public static int calculate(String s) {
        int currentNum = 0;
        int previousNum = 0;
        int result = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + Character.getNumericValue(c);
            } 
            if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
                if (operation == '-' || operation == '+') {
                    result += previousNum;
                    previousNum = operation == '+' ? currentNum : -currentNum;
                } 
                else if (operation == '*') {
                    previousNum = previousNum * currentNum;
                } 
                else {
                    previousNum = previousNum / currentNum;
                }
                operation = c;
                currentNum = 0;
            }
        }
        result += previousNum;
        return result;
    }
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println("Calculated value of the string: "+calculate(s));
    }
}