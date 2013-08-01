public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() == 0) {
            return s2.equals(s3);
        } else if (s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

		int M = s1.length();
		int N = s2.length();
		int [][] dp = new int[M + 1][N + 1];
		dp[0][0] = -1;
		if (s2.charAt(0) != s3.charAt(0)) {
			dp[0][1] = -1;
		}
		for (int j = 2; j <= N; ++j) {
			if (dp[0][j - 1] != -1 && s3.charAt(dp[0][j - 1] + 1) == s2.charAt(j - 1)) {
				dp[0][j] = dp[0][j - 1] + 1;
			} else {
				dp[0][j] = -1;
			}
		}
		if (s1.charAt(0) != s3.charAt(0)) {
			dp[1][0] = -1;
		}
		for (int i = 2; i <= M; ++i) {
			if (dp[i - 1][0] != -1 && s3.charAt(dp[i - 1][0] + 1) == s1.charAt(i - 1)) {
				dp[i][0] = dp[i - 1][0] + 1;
			} else {
				dp[i][0] = -1;
			}
		}

		for (int i = 1; i <= M; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (dp[i - 1][j] != -1 && s3.charAt(dp[i - 1][j] + 1) == s1.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j] + 1;
				} else if (dp[i][j - 1] != -1 && s3.charAt(dp[i][j - 1] + 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1] + 1;
				} else {
					dp[i][j] = -1;
				}
			}
		}
		
		for (int i = 0; i <= M; ++i) {
			for (int j = 0; j <= N; ++j) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[M][N] == s3.length() - 1;
        
    }
    
	public static void main(String args[]) {

		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().isInterleave(s1, s2, s3));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}

