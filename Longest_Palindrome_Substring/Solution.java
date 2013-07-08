public class Solution {
	public String longestPalindrome(String s) {
		if (s == null) {
			return null;
		} else if (s.length() == 0 || s.length() == 1) {
			return s;
		}

		int N = s.length();
		int maxLen = 1;
		int maxRow = 0;
		int maxCol = 1;
		boolean [][] dp = new boolean [N][N];
		for (int lastRow = N - 1; lastRow >= 0; --lastRow) {
			for (int row = 0; row <= lastRow; ++row) {
				int col = row + (N - 1 - lastRow);
				if (col == row) {
					dp[row][col] = true;
				} else if (s.charAt(col) == s.charAt(row)
						&& ((col - row) == 1 || dp[row + 1][col - 1] == true)) {
					dp[row][col] = true;
					if (col - row + 1 > maxLen) {
						maxLen = col - row + 1;
						maxRow = row;
						maxCol = col;
					}
				}
			}
		}
		return s.substring(maxRow, maxCol + 1);
	}

	public static void main(String args[]) {
		String s = "aaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa";
		System.out.println(new Solution().longestPalindrome(s));
	}
}
