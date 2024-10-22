/*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: c = 3
Output: false
*/
public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while(a<=b){
            if(((a*a) + (b*b)) == c){
                return true;
            }
            else if((((a*a)+(b*b)) < c)){
                a++;
            }
            else{
                b--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int c = 5;
        System.out.println("Sum of square numbers:"+judgeSquareSum(c));
    }
}