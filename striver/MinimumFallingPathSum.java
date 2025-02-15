import java.util.Arrays;

class MinimumFallingPathSum {
    int[][] dp;
    public int solve(int i, int j, int[][] grid){
        
        if(i<0 || j<0 || j>=grid.length || i>=grid.length) return (int)1e9;
        if(i==0) return grid[i][j];

        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int up = solve(i-1, j, grid);
        int dLeft = solve(i-1, j-1, grid);
        int dRight = solve(i-1, j+1, grid);

        return dp[i][j] = Math.min(up, Math.min(dLeft, dRight)) + grid[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        dp = new int[n+1][n+1];

        for(int[] d: dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        // In question it is stated min of all paths 
        // not like usual just a min path !!!! was getting wrong bcoz of this
        for(int i=0; i<n; i++){
            ans = Math.min(ans, solve(n-1, i, matrix));
        }
        return ans;
    }
}