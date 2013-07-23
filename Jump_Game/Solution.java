public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0 || A.length == 1) {
                return true;
        }
        
        int i = 0;
        while (i + A[i] < A.length - 1) {
            int pIndex = i;
            for (int j = i; j <= i + A[i]; ++j) {
                if (j + A[j] > pIndex + A[pIndex]) {
                    pIndex = j;
                }
            }
            if (pIndex == i) {
                return false;
            }
            i = pIndex;
        }
        return true;
    }
}
