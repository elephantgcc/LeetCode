public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (T.length() == 0) {
            return 1;
        } else if (S.length() == 0) {
            return 0;
        } else if (S.length() < T.length()) {
            return 0;
        }
        
        int M = T.length();
        int N = S.length();
        
        int[][] dp = new int[M + 1][N + 1];
        for (int j = 0; j <= N; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= M; ++i) {
            for (int j = i; j <= N; ++j) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[M][N];
    }
}
