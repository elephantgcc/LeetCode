public class Solution {
    public boolean isScramble(String s1, String s2) {
		if (s1.length() == 0) {
			return s1.length() == 0;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		int N = s1.length();
		boolean[][][] dp = new boolean[N + 1][N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));
			}
		}
		for (int len = 2; len <= N; ++len) {
			for (int i = 0; i <= N - len; ++i) {
				for (int j = 0; j <= N - len; ++j) {
					for (int subLen = 1; subLen < len; ++subLen) {
						if ((dp[subLen][i][j] && dp[len - subLen][i + subLen][j + subLen])
								|| (dp[subLen][i][j + len - subLen] && dp[len - subLen][i + subLen][j])) {
							dp[len][i][j] = true;
							break;
						}
					}
				}
			}
		}
		return dp[N][0][0];
    }

	public static void main(String args[]) {
		//           01234
		String s1 = "abcd";
		String s2 = "cadb";
		System.out.println(new Solution().isScramble(s1, s2));

	}
}
