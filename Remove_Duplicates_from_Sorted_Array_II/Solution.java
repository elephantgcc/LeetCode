public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 2) {
            return A.length;
        }
        
        int j = 1;
        int same = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] == A[i - 1]) {
                ++same;
            } else {
                A[j] = A[i];
                same = 1;
                ++j;
                continue;
            }
            
            if (same == 2) {
                A[j] = A[i];
                ++j;
            }
        }
        
        return j;
    }
}
