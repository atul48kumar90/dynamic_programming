/*
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.


 */

import java.util.Arrays;

class CoinChange2 {
    public int change(int x, int[] num) {
        int n = num.length;
        int[][] dp = new int[num.length][x+1];
        
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return  countWaysToMakeChangeUtil(num, n - 1, x, dp);
    }

    public int countWaysToMakeChangeUtil(int[] arr, int ind, int T, int[][] dp) 
    {
         if (ind == 0) {
            // If T is divisible by the first element of the array, return 1, else return 0
            if (T % arr[0] == 0)
                return 1;
            else
                return 0;
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the number of ways without taking the current element
        int notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

        // Initialize the number of ways taking the current element as 0
        int taken = 0;

        // If the current element is less than or equal to T, calculate 'taken'
        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

        // Store the result in the dp array and return it
        return dp[ind][T] = notTaken + taken;
    }
}
