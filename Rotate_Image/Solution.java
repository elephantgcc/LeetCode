public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function

		if (matrix == null || matrix.length == 0) {
			return;
		}

		rotateCore(matrix, 0, 0, matrix.length);
    }

	public void rotateCore(int[][] matrix, int x, int y, int N) {

		if (N < 2) {
			return;
		}

		for (int k = 0; k <= N - 2; ++k) {
			int temp = matrix[x][y + k];
			matrix[x][y + k] = matrix[x + N - 1 - k][y];
			matrix[x + N - 1 - k][y] = matrix[x + N - 1][y + N - 1 - k];
			matrix[x + N - 1][y + N - 1 - k] = matrix[x + k][y + N - 1];
			matrix[x + k][y + N - 1] = temp;
		}
		
		rotateCore(matrix, x + 1, y + 1, N - 2);
	}

	public static void main(String args[]) {
		int [][] matrix = new int[][] { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		new Solution().rotate(matrix);
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
