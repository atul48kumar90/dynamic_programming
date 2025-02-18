/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
Solved
Medium
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 */

import java.util.Arrays;

class BuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        return f(0, 1, prices, n, dp);
    }

    public int f(int ind, int buy, int[] prices, int n, int[][] dp)
    {
        if(ind >= n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;

        if(buy == 1)
        {
            return dp[ind][buy] = Math.max(-prices[ind] + f(ind+1, 0, prices, n, dp), 0 + f(ind+1, 1, prices, n, dp));
        } else {
            return dp[ind][buy] = Math.max(prices[ind] + f(ind+2, 1, prices, n, dp), 0 + f(ind+1, 0, prices, n, dp));
        }

        //return dp[ind][buy] = profit;
    }
}