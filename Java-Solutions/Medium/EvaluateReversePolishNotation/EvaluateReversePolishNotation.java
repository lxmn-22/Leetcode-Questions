/*
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish
 * notation.
 * The answer and all the intermediate calculations can be represented in a
 * 32-bit integer.
 * 
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */

class EvaluateReversePolishNotation {
    static long resolves(long a, long b, char Operator) {
        if (Operator == '+') {
            return a + b;
        } else if (Operator == '-') {
            return a - b;
        } else if (Operator == '*') {
            return a * b;
        }
        return a / b;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
                long int2 = stack.pop();
                long int1 = stack.pop();
                char operator = tokens[i].charAt(0);
                long resolvedAns = resolves(int1, int2, operator);
                stack.push(resolvedAns);
            } else {
                stack.push(Long.parseLong(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }
}