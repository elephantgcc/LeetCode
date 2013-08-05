public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int M = matrix.length;
        int N = matrix[0].length;
        
        int i = 0;
        int j = M * N - 1;
        
        while (i <= j) {
            int mid = (i + j) / 2;
            int x = mid / N;
            int y = mid % N;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        
        return false;
    }
}
