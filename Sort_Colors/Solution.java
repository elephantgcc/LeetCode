public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0 || A.length == 1) {
            return;
        }
        
        int x = 0;
        int i = 0;
        int j = A.length - 1;
        
        while (x <= j) {
            if (A[i] == 0) {
                ++i;
                ++x;
                continue;
            }
            if (A[j] == 2) {
                --j;
                continue;
            }
            
            if (A[x] == 1) {
                ++x;
            } else if (A[x] == 2) {
                A[x] = A[j];
                A[j] = 2;
                --j;
            } else if (A[x] == 0) {
                A[i] = 0;
                A[x] = 1;
                ++i;
                ++x;
            }
        }
    }
}
