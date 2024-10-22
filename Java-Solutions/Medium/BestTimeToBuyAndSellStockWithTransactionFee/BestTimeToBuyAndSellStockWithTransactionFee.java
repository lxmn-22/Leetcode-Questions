/*
You are given an array prices where prices[i] is the price of a given stock on the ith day, 
and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, 
but you need to pay the transaction fee for each transaction.

Note:
You may not engage in multiple transactions simultaneously (i.e., you must sell the stock 
before you buy again).
The transaction fee is only charged once for each stock purchase and sale.

Example 1:
Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
package Medium.BestTimeToBuyAndSellStockWithTransactionFee;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] notHolding = new int[n];
        int[] holding = new int[n];
        holding[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            holding[i] = Math.max(holding[i - 1], notHolding[i - 1] - prices[i]);
            notHolding[i] = Math.max(notHolding[i - 1], holding[i - 1] + prices[i] - fee);
        }
        return notHolding[n - 1];
    }

    public static void main(String[] args) {
        int[] prices = ;
        int fee = ;
        System.out.println("Maximum Profit: "+maxProfit(prices, fee));
    }
}