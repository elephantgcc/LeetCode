public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while ( i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[index] = A[i];
                --i;
                --index;
            } else {
                A[index] = B[j];
                --j;
                --index;
            }
        }
        if (i < 0) {
            for (int k = 0; k <= j; ++k) {
                A[k] = B[k];
            }
        }
        return;
    }
}
