public class Solution {
    public void solveSudoku(char[][] board) {
            isSolved(board);
	}

	private boolean isSolved(char[][] board) {
		int i = 0, j = 0;
		for (i = 0; i < 9; ++i) {
			for (j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; ++k) {
						board[i][j] = k;
						if (isValid(board, i, j) && isSolved(board)) {
							return true;
						}
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int i, int j) {
		for (int y = 0; y < 9; ++y) {
			if (board[i][y] != '.' && y != j) {
				if (board[i][y] == board[i][j]) {
					return false;
				}
			}
		}
		for (int x = 0; x < 9; ++x) {
			if (board[x][j] != '.' && x != i) {
				if (board[x][j] == board[i][j]) {
					return false;
				}
			}
		}
		for (int x = i / 3 * 3; x <= i / 3 * 3 + 2; ++x) {
			for (int y = j / 3 * 3; y <= j / 3 * 3 + 2; ++y) {
				if (board[x][y] != '.' && x != i && y != j) {
					if (board[x][y] == board[i][j]) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String args[]) {
		char[][] board = new char[9][9];
String [] input = {
"..9748...",
"7........",
".2.1.9...",
"..7...24.",
".64.1.59.",
".98...3..",
"...8.3.2.",
"........6",
"...2759.."};
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				board[i][j] = input[i].charAt(j);
			}
		}
long t1 = System.currentTimeMillis();
		new Solution().solveSudoku(board);
long t2 = System.currentTimeMillis();
System.out.println(t2 - t1);

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
