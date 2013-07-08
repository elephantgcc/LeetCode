public class Solution {
	public int lengthOfLongestSubstring(String s) {
        	if (s == null || s.length() == 0) {
			return 0;
		}
		int N = s.length();
		int[][] dp = new int[N][N];
		int maxLen = 1;
		for (int i = 0; i < N; ++i) {
			dp[i][i] = 1;
		}
		for (int row = 0; row <= N - 2; ++row) {
			for (int col = row + 1; col <= N - 1; ++col) {
				if (dp[row][col - 1] > 0 && s.substring(row, col).indexOf(s.charAt(col)) == -1) {
					dp[row][col] = dp[row][col - 1] + 1;
					maxLen = Math.max(maxLen, dp[row][col]);
				} else {
					dp[row][col] = 0;
				}
			}
		}
		return maxLen;
	}

	public static void main(String args[]) {
		String s = "inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparatinginprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating";
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().lengthOfLongestSubstring(s));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
