import java.util.* ;
import java.io.*; 

public class knapsack{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
            int[][] dp = new int[n][maxWeight+1];
            for(int[] row : dp)
            {
                Arrays.fill(row, -1);
            }

            return f(weight, value, n-1, maxWeight, dp);

    }

    public static int f(int[] wt, int[] value, int n, int maxWeight, int[][] dp)
    {
        if(n == 0)
        {
            if(wt[n] <= maxWeight)
            {
                return value[n];
            }else {
                return 0;
            }
        }

        if(dp[n][maxWeight] != -1) return dp[n][maxWeight];

        int not_take = 0 + f(wt, value, n-1, maxWeight, dp);
        int take = Integer.MIN_VALUE;

        if(wt[n] <= maxWeight)
        {
            take = value[n] + f(wt, value, n-1, maxWeight - wt[n], dp);
        }

        return dp[n][maxWeight] =  Math.max(take, not_take);
    }
}