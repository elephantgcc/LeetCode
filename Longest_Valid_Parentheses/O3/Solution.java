public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}
		int result = 0;
		int N = s.length();
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; ++i) {
			dp[i][i] = Integer.MIN_VALUE;
			if (i > 0) {
				dp[i][i - 1] = Integer.MIN_VALUE;
			}
		}
		for (int lastRow = N - 2; lastRow >= 0; --lastRow) {
			for (int row = 0; row <= lastRow; ++row) {
				int col = row + N - 1 - lastRow;

				int max = Integer.MIN_VALUE;
				if ((s.charAt(row) == '(' && s.charAt(col) == ')')) {
					if (row + 1 == col) {
						max = 2;
					} else if (dp[row + 1][col - 1] != Integer.MIN_VALUE) {
						max = dp[row + 1][col - 1] + 2;
					}
				}

				for (int iterCol = row; iterCol < col; ++iterCol) {
					int iterRow = iterCol + 1;
					if (dp[row][iterCol] != Integer.MIN_VALUE && dp[iterRow][col] != Integer.MIN_VALUE) {
						max = Math.max(max, dp[row][iterCol] + dp[iterRow][col]);
					}
				}

				dp[row][col] = max;
				result = Math.max(result, dp[row][col]);
			}
		}
		return result;
    }

	public static void main(String args[]) {
		String s = "((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))";
		System.out.println(new Solution().longestValidParentheses(s));
	}
}