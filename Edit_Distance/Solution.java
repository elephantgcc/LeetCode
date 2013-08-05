 public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        } else if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        
        int M = word1.length(), N = word2.length();
        int [][] dp = new int[M + 1][N + 1];
        for (int j = 0; j <= N; ++j) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= M; ++i) {
            dp[i][0] = i;
        }
        
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                int min = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    min = dp[i - 1][j - 1];
                } else {
                    min = dp[i - 1][j - 1] + 1;
                }
                min = Math.min(Math.min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1),
                                min);
                dp[i][j] = min;
            }
        }
        return dp[M][N];
    }
}



