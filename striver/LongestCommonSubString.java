/*
 * Problem statement
You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.



A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.



Example:
Input: ‘str1’ = “abcjklp” , ‘str2’ = “acjkp”.

Output: 3

Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.
 */


public class LongestCommonSubString {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int j=0; j<=m; j++) dp[0][j] = 0;
        for(int i=0; i<=n; i++) dp[i][0] = 0;

        int ans = 0;

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }
}
