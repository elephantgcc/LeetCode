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
        int [][] dp = new int [M + 1][N + 1];
        
        return isInterleave(dp, s1, s2, s3, 0, 0, 0);
    }
    
    private boolean isInterleave(int[][] dp, String s1, String s2, String s3,
            int x, int y, int next) {
        
        if (x + 1 <= dp.length - 1 && s1.charAt(x) == s3.charAt(next)) {
            if (next == s3.length() - 1) {
                return true;
            } else if (isInterleave(dp, s1, s2, s3, x + 1, y, next + 1)) {
                return true;
            }
        }
        
        if (y + 1 <= dp[0].length - 1 && s2.charAt(y) == s3.charAt(next)) {
            if (next == s3.length() - 1) {
                return true;
            } else if (isInterleave(dp, s1, s2, s3, x, y + 1, next + 1)) {
                return true;
            }
        }
        
        return false;
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

