import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	for (int i = 0; i < 9; ++i) {
			HashSet<Character> histogram = new HashSet<Character>();
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] >= '1' && board[i][j] <='9') {
					if (histogram.contains(board[i][j])) {
						return false;
					} else {
						histogram.add(board[i][j]);
					}
				}
			}
		}
    	for (int j = 0; j < 9; ++j) {
			HashSet<Character> histogram = new HashSet<Character>();
			for (int i = 0; i < 9; ++i) {
				if (board[i][j] >= '1' && board[i][j] <='9') {
					if (histogram.contains(board[i][j])) {
						return false;
					} else {
						histogram.add(board[i][j]);
					}
				}
			}
		}
		for (int i = 1; i <= 7; i += 3) {
			for (int j = 1; j <= 7; j += 3) {
				HashSet<Character> histogram = new HashSet<Character>();
				for (int k = i - 1; k <= i + 1; ++k) {
					for (int l = j - 1; l <= j + 1; ++l) {
						if (board[k][l] >= '1' && board[k][l] <='9') {
							if (histogram.contains(board[k][l])) {
		                        return false;
        		            } else {
                		        histogram.add(board[k][l]);
                   			}
						}
					}
				}//for k, l
			}
		}//for i, j

		return true;
    }

	public static void main(String args[]) {
		char[][] board = new char[9][9];
		String [] input = new String[] {
				"53..7....",
				"6..195...",
				".98....6.",
				"8...6...3",
				"4..8.3..1",
				"7...2...6",
				".6....28.",
				"...419..5",
				"....8..79"};
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				board[i][j] = input[i].charAt(j);
			}
		}

		System.out.println(new Solution().isValidSudoku(board));
	}
}
