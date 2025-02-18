
/*
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
Solved
Medium
Topics
Companies
Hint
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
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
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 */

import java.util.Arrays;

class BuyAndSeelWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return f(0, 1, prices, n, fee, dp);
    }

    public int f(int ind, int buy, int[] prices, int n, int fee, int[][] dp)
    {
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;

        if(buy == 1)
        {
            profit = Math.max(-prices[ind] + f(ind+1, 0, prices, n, fee, dp), 0 + f(ind+1, 1, prices, n, fee, dp));
        } else{
            profit = Math.max((prices[ind] - fee + f(ind+1, 1, prices, n, fee, dp)), (0 + f(ind+1, 0, prices, n, fee, dp)));
        }

        return dp[ind][buy] = profit;
    }
}