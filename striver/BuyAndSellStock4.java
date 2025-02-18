/*188. Best Time to Buy and Sell Stock IV
Solved
Hard
Topics
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3. */


import java.util.Arrays;

class BuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1]; // Adding cap dimension
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return f(0, 1, k, prices, prices.length, dp);
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