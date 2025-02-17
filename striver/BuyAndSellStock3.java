/*
 * 123. Best Time to Buy and Sell Stock III
Solved
Hard
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

import java.util.Arrays;

class BuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3]; // Adding cap dimension
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return f(0, 1, 2, prices, prices.length, dp);
    }

    public int f(int index, int buy, int cap, int[] prices, int n, int[][][] dp) {
        if (index == n || cap == 0) return 0;
        if (dp[index][buy][cap] != -1) return dp[index][buy][cap];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(
                -prices[index] + f(index + 1, 0, cap, prices, n, dp), 
                f(index + 1, 1, cap, prices, n, dp)
            );
        } else {
            profit = Math.max(
                prices[index] + f(index + 1, 1, cap - 1, prices, n, dp), 
                f(index + 1, 0, cap, prices, n, dp)
            );
        }

        return dp[index][buy][cap] = profit;
    }
}
