/*
You are given an integer array prices representing the prices of various chocolates in a store. You are also given a single 
integer money, which represents your initial amount of money.

You must buy exactly two chocolates in such a way that you still have some non-negative leftover money. You would like to 
minimize the sum of the prices of the two chocolates you buy.

Return the amount of money you will have leftover after buying the two chocolates. If there is no way for you to buy two 
chocolates without ending up in debt, return money. Note that the leftover must be non-negative.

Example 1:
Input: prices = [1,2,2], money = 3
Output: 0
Explanation: Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
 */
package Easy.BuyTwoChocolates;

class BuyTwoChocolates {
    public static int buyChoco(int[] prices, int money) {
        int cheapestChocolate = Math.min(prices[0], prices[1]);
        int secondCheapestChocolate = Math.max(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < cheapestChocolate) {
                secondCheapestChocolate = cheapestChocolate;
                cheapestChocolate = prices[i];
            } else if (prices[i] < secondCheapestChocolate) {
                secondCheapestChocolate = prices[i];
            }
        }
        int totalCost = cheapestChocolate + secondCheapestChocolate;
        return totalCost <= money ? (money - totalCost) : money;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 2 };
        int money = 3;
        System.out.println("Buy Two chocolates: " + buyChoco(prices, money));
    }
}