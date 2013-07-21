public class Solution {

	public boolean isMatch(String s, String p) {
		p = p.replaceAll("\\*+", "*");
		return isMatchCore(s, p);
	}

    public boolean isMatchCore(String s, String p) {

		int P = p.length();
		int S = s.length();
		if (P == 0) {
			return S == 0;
		}
		if (S == 0) {
			return P == 0 || p.equals("*");
		}

		boolean [][] dp = new boolean [P + 1][S + 1];
		dp[0][0] = true; // s.BOS == p.BOS
		if (p.charAt(0) == '*') { // s.BOS == p.BOS_*, NOTE, no repeated *
			dp[1][0] = true;
		}

		for (int i = 1; i <= P; ++i) {
			for (int j = 1; j <= S; ++j) {
				if (p.charAt(i - 1) == '*') {
					boolean prevMatch = false;
					for (int k = j; k >= 0; --k) {
						if (dp[i - 1][k]) {
							prevMatch = true;
							break;
						}
					}
					dp[i][j] = prevMatch;
				} else if (p.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = (p.charAt(i - 1) == s.charAt(j - 1) && dp[i - 1][j - 1]);
				}
			}
		}
					
		return dp[P][S];
    }

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().isMatch("abba", "ba*"));
		//System.out.println(new Solution().isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
