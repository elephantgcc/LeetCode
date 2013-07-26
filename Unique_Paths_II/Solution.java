public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        int [][] A = obstacleGrid;
        
        int [][] dp = new int [M][N];
        for (int j = 0; j < N; ++j){
            if (A[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < M; ++i) {
            if (A[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < M; ++i) {
            for (int j = 1; j < N; ++j) {
                if (A[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[M - 1][N - 1];
    }
}
