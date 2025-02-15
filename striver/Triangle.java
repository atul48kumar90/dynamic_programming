import java.util.Arrays;
import java.util.List;

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        return f(0,0,triangle, dp);
    }

    public int f(int i, int j, List<List<Integer>> triangle, int[][] dp)
    {
        if(i == triangle.size() -1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + f(i+1, j, triangle, dp);
        int right = triangle.get(i).get(j) + f(i+1, j+1, triangle, dp);

        return dp[i][j] = Math.min(down, right);
    }
}