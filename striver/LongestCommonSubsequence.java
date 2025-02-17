/*
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */


import java.util.Arrays;

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];  // Include space for the base case (index 0)

        for(int[] row : dp) {
            Arrays.fill(row, -1);  // Initialize the dp array with -1 for memoization
        }

        return f(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    public int f(String t1, String t2, int n1, int n2, int[][] dp) {
        if (n1 < 0 || n2 < 0) {
            return 0;  // Base case: if either string is exhausted, return 0
        }

        if (dp[n1 + 1][n2 + 1] != -1) {
            return dp[n1 + 1][n2 + 1];  // Use the memoized result
        }

        if (t1.charAt(n1) == t2.charAt(n2)) {
            dp[n1 + 1][n2 + 1] = 1 + f(t1, t2, n1 - 1, n2 - 1, dp);  // If characters match
        } else {
            dp[n1 + 1][n2 + 1] = Math.max(
                f(t1, t2, n1 - 1, n2, dp),  // Move in text1
                f(t1, t2, n1, n2 - 1, dp)   // Move in text2
            );
        }

        return dp[n1 + 1][n2 + 1];
    }
}
