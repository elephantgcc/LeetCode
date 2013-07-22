import java.util.*;

public class Solution {

	static ArrayList<String[]> result = null;

    public ArrayList<String[]> solveNQueens(int n) {
		result = new ArrayList<String[]>();
		char [][] board = new char [n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = '.';
			}
		}
		solveNQueens(board, 0);
		return result;
    }

	private void solveNQueens(char[][] board, int row) {

		int N = board.length;
		if (row == N) {
			addToResult(board);
			return;
		}

		for (int i = 0; i < N; ++i) {
			board[row][i] = 'Q';
			if(isValid(board, row, i)) {
				solveNQueens(board, row + 1);
			}
			board[row][i] = '.';
		}
	}

	private void addToResult(char[][] board) {
		int N = board.length;
		String[] ans = new String[N];
		for (int i = 0; i < N; ++i) {
			ans[i] = "";
			for (int j = 0; j < N; ++j) {
				ans[i] += board[i][j];
			}
		}
		result.add(ans);
		return;
	}

	private boolean isValid(char[][] board, int i, int j) {
		int N = board.length;

		for (int k = 0; k < N; ++k) {
			if (board[i][k] == 'Q' && k != j) {
				return false;
			}
			if (board[k][j] == 'Q' && k != i) {
				return false;
			}
		}
		int m = i - 1;
		int n = j - 1;
		while (m >= 0 && n >= 0) {
			if(board[m][n] == 'Q') {
				return false;
			}
			--m;
			--n;
		}
		m = i - 1;
		n = j + 1;
		while (m >= 0 && n <= N - 1) {
			if(board[m][n] == 'Q') {
				return false;
			}
			--m;
			++n;
		}
		m = i + 1;
		n = j - 1;
		while (m <= N - 1 && n >= 0) {
			if(board[m][n] == 'Q') {
				return false;
			}
			++m;
			--n;
		}
		m = i + 1;
		n = j + 1;
		while (m <= N - 1 && n <= N - 1) {
			if(board[m][n] == 'Q') {
				return false;
			}
			++m;
			++n;
		}
		
		return true;
	}

	public static void main(String args[]) {
		ArrayList<String[]> result = new Solution().solveNQueens(8);
		System.out.println(result.size());
		for (int i = 0; i < result.size(); ++i) {
			for (String s : result.get(i)) {
				System.out.println(s);
			}
			System.out.println();
		}

	}
}
