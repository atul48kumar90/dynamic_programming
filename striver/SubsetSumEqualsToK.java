/*
 * Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
 */


import java.util.* ;
import java.io.*; 
public class SubsetSumEqualsToK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        //int n = arr.length;

        int[][] dp = new int[n][k+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return f(n-1, k, arr, dp);
    }

    public static boolean f(int n, int target, int[] arr, int[][] dp)
    {
        if(target == 0) return true;
        if(n == 0) return arr[n]==target;
        if (dp[n][target] != -1) return dp[n][target] == 1;

        boolean not_take = f(n-1, target, arr, dp);
        boolean take = false;
        if(arr[n] <= target)
        {
            take = f(n-1, target-arr[n], arr, dp);
        }

        dp[n][target] = (take | not_take) ? 1 : 0;

        return take || not_take;
    }
}
