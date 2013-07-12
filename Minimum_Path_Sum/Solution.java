public class Solution {
	public int minPathSum(int[][] grid) {
       		if (grid == null || grid.length == 0) {
			return 0;
		}
		int M = grid.length;
		int N = grid[0].length;
		int [][] dp = new int [M][N];
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if ( i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				}
			}
		}
		return dp[M - 1][N - 1];
	}

	public static void main(String args[]) {
		int [][] grid = new int[][] {   {1, 2},
						{1, 1},
					    };
		System.out.println(new Solution().minPathSum(grid));
	}
}
