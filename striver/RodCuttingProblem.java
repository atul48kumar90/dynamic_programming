/*
 * Problem statement
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

3. Consider 1-based indexing.
 */

import java.util.*;

public class RodCuttingProblem {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[price.length][n+1];

		for(int[] row : dp)
		{
			Arrays.fill(row, -1);
		}

		return f(price.length - 1, price, n, dp);
	}

	public static int f(int index, int[] price, int n, int[][] dp)
	{
		if(index == 0)
		{
			return price[index]*n;
		}
		if(dp[index][n] != -1) return dp[index][n];

		int not_pick = 0 + f(index-1, price, n, dp);
		int pick = Integer.MIN_VALUE;

		int rodLength = index + 1;
		if(rodLength <= n)
		{
			pick = price[index] + f(index, price, n- rodLength, dp);
		}

		return dp[index][n] = Math.max(pick, not_pick);
	}
}