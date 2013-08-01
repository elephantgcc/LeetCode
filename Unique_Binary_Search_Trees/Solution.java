public class Solution {
    public int numTrees(int n) {

        int [] dp = new int [n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = 2 * dp[i - 1];
            for (int j = 2; j < i; ++j) {
                int leftLen = j - 1;
                int rightLen = i - j;
                dp[i] += dp[leftLen] * dp[rightLen];
            }
        }
        return dp[n];
    }
}
