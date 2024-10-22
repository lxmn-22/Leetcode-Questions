/*
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will 
put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the 
previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

Example 1:
Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.
 */
package Easy.CalculateMoneyInLeetcodeBank;

public class CalculateMoneyInLeetcodeBank {
    public static int totalMoney(int n) {
        int totalAmount = 0;
        int mondayMoney = 1;
        while (n > 0) {
            totalAmount += mondayMoney++;
            n--;
            int daysInWeek = Math.min(6, n);
            totalAmount += getCummulativeSum(mondayMoney, daysInWeek);
            n -= daysInWeek;
        }
        return totalAmount;
    }

    private static int getCummulativeSum(int firstTerm, int n) {
        if (n <= 0) {
            return 0;
        }
        return ((2 * firstTerm + (n - 1)) * n) / 2;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Total Money: " + totalMoney(n));
    }
}