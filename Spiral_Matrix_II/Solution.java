public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][] result = new int [n][n];
        if (n <= 0) {
            return result;
        }
        generateMatrixCore(result, 0, 0, n, 1);
        return result;
    }
    
    public void generateMatrixCore(int [][] A, int x, int y, int N, int start) {
        
        if (N <= 0){
            return;
        } else if (N == 1) {
			A[x][y] = start;
			return;
		}
        
        for (int k = y; k <= y + N - 2; ++k) {
            A[x][k] = start;
            ++start;
        }
        for (int k = x; k <= x + N - 2; ++k) {
            A[k][y + N - 1] = start;
            ++start;
        }
        for (int k = y + N - 1; k >= y + 1; --k) {
            A[x + N - 1][k] = start;
            ++start;
        }
        for (int k = x + N - 1; k >= x + 1; --k) {
            A[k][y] = start;
            ++start;
        }
        
        generateMatrixCore(A, x + 1, y + 1, N - 2, start);
    }
    
	public static void main(String args[]) {
		int [][] a = new Solution().generateMatrix(1);
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a[i].length; ++j) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
