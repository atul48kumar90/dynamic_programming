/*
 Problem statement
You are given an array of ‘N’ distinct integers and an integer ‘X’ representing the target sum. You have to tell the minimum number of elements you have to take to reach the target sum ‘X’.

Note:
You have an infinite number of elements of each type.
For example
If N=3 and X=7 and array elements are [1,2,3]. 
Way 1 - You can take 4 elements  [2, 2, 2, 1] as 2 + 2 + 2 + 1 = 7.
Way 2 - You can take 3 elements  [3, 3, 1] as 3 + 3 + 1 = 7.
Here, you can see in Way 2 we have used 3 coins to reach the target sum of 7.
Hence the output is 3.
 */

import java.util.* ;
import java.io.*; 
public class MinimumCoins {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int[][] dp = new int[num.length][x+1];

        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int ans = f(num, x, num.length-1, dp);
        if(ans == (int)1e9)
        {
            return -1;
        }
        return ans;
    }

    public static int f(int[] num, int x, int ind, int[][] dp)
    {
        if(ind == 0)
        {
            if(x%num[ind] == 0) return x/(num[ind]);
            return (int)1e9;
        }
        if(dp[ind][x] != -1) return dp[ind][x];
        int not_take = 0 + f(num, x, ind-1, dp);

        int take = Integer.MAX_VALUE;
        if(num[ind] <= x)
        {
           take = 1 + f(num, x - num[ind], ind, dp);
        }

        return dp[ind][x] =  Math.min(take, not_take);
    }

}