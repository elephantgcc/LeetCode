import java.util.*;

public class Solution {

	static int result = 0;

    public int totalNQueens(int n) {
		result = 0;
		int [] queens = new int [n];
		totalNQueensCore(queens, 0);
		return result;
    }

	private void totalNQueensCore(int [] queens, int row) {

		int N = queens.length;
		if (row == N) {
			++result;
			return;
		}

		for (int i = 0; i < N; ++i) {
			queens[row] = i;
			if(isValid(queens, row)) {
				totalNQueensCore(queens, row + 1);
			}
		}
	}

	private boolean isValid(int [] queens, int row) {
		for (int i = 0; i < row; ++i) {
			int diff = (int)Math.abs(queens[row] - queens[i]);
			if (diff == 0 || diff == row - i) {
				return false;
			}
		}	
		return true;
	}

	public static void main(String args[]) {
		new Solution().totalNQueens(12);
		System.out.println(result);
	}
}
