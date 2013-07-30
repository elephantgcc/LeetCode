 public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        setZerosCore(matrix, 0);
        return;
    }
    
    private void setZerosCore(int[][] A, int row) {
    
        if (row == A.length) {
            return;
        }
    
        int N = A[0].length;
        
        boolean hasZero = false;
        for (int j = 0; j < N; ++j) {
            if (A[row][j] == 0) {
                for (int i = 0; i <= row - 1; ++i) {
                    A[i][j] = 0;
                }
                hasZero = true;
            }
        }
        
        setZerosCore(A, row + 1);
        
        for (int j = 0; j < N; ++j) {
            if (A[row][j] == 0) {
                for (int i = row + 1; i < A.length; ++i) {
                    A[i][j] = 0;
                }
            }
        }
        
        if (hasZero) {
            for (int j = 0; j < N; ++j) {
                A[row][j] = 0;
            }
        }
        
        return;
    }
}



