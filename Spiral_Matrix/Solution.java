import java.util.*;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new ArrayList<Integer>();
		}
		return spiralOrderCore(matrix, 0, matrix.length, 0, matrix[0].length);
    }

	private ArrayList<Integer> spiralOrderCore(int[][] A, int x, int M, int y, int N) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (M <= 0 || N <= 0) {
			return result;
		}
		if (M == 1) {
			for (int k = y; k <= y + N - 1; ++k) {
				result.add(A[x][k]);
			}
			return result;
		}
		if (N == 1) {
			for (int k = x; k <= x + M - 1; ++k) {
				result.add(A[k][y]);
			}
			return result;
		}

		for (int k = y; k <= y + N - 2; ++k) {
			result.add(A[x][k]);
		}
		for (int k = x; k <= x + M - 2; ++k) {
			result.add(A[k][y + N - 1]);
		}
		for (int k = y + N - 1; k >= y + 1; --k) {
			result.add(A[x + M - 1][k]);
		}
		for (int k = x + M - 1; k >= x + 1; --k) {
			result.add(A[k][y]);
		}
		
		ArrayList<Integer> inner = spiralOrderCore(A, x + 1, M - 2, y + 1, N - 2);
		result.addAll(inner);
		return result;
	}

	public static void main(String args[]) {
		int [][] a = new int [3][5];
		for (int i = 0 ;i < a.length; ++i) {
			for (int j = 0; j < a[i].length; ++j) {
				a[i][j] = i + j;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(new Solution().spiralOrder(a));
	}
}
