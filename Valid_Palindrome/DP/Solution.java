public class Solution {
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}

		int N = s.length();
		boolean [][] dp = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			dp[i][i] = true;
		}

		for (int lastRow = N - 2; lastRow >= 0; --lastRow) {
			for (int row = 0; row <= lastRow; ++row) {
				int col = row + N - lastRow - 1;
				if (!isAlphaNumeric(s.charAt(row))) {
					dp[row][col] = dp[row + 1][col];
					continue;
				}
				if (!isAlphaNumeric(s.charAt(col))) {
					dp[row][col] = dp[row][col - 1];
					continue;
				}
				if ((s.charAt(row) == s.charAt(col)
						|| s.charAt(row) == s.charAt(col) + ('a' - 'A')
						|| s.charAt(row) + ('a' - 'A') == s.charAt(col))
							&& (col - row == 1 || dp[row + 1][col - 1] == true)) {
					dp[row][col] = true;
				}
			}
		}
		return dp[0][N - 1];
        
	}

	private boolean isAlphaNumeric(char c) {
		if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'z')) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		String s = "aA";
		System.out.println(new Solution().isPalindrome(s));
	}
}
