/*
 * Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.



Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.



Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.


 */

import java.util.*;

public class CountSubSetWithSumK {
    public static int findWays(int num[], int target) {
        int n = num.length;
        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countSubsets(n - 1, target, num, dp);
    }

    public static int countSubsets(int ind, int target, int[] num, int[][] dp) {
        if (target == 0) return 1; // Found a valid subset
        if (ind < 0) return 0; // No elements left
        if (dp[ind][target] != -1) return dp[ind][target];

        // Not picking the current element
        int not_pick = countSubsets(ind - 1, target, num, dp);

        // Picking the current element (allow zeros)
        int pick = 0;
        if (num[ind] <= target) { // Fix: Ensure we don't go negative
            pick = countSubsets(ind - 1, target - num[ind], num, dp);
        }

        return dp[ind][target] = pick + not_pick;
    }
}
