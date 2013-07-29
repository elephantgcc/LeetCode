public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0) {
            return false;
        }
        
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            
            if (A[mid] == A[i] && A[mid] == A[j]) { // 2 3 2 2 2 , 2 2 2 1 2
                if (target == A[mid]) {
                    return true;
                } else {
                    boolean leftBig = false;
                    for (int k = i + 1; k < mid; ++k) {
                        if (A[k] > A[mid]) {
                            leftBig = true;
                            break;
                        }
                    }
                    if (leftBig) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                }
            } else if (A[mid] <= A[j] && A[j] <= A[i]) { // mid in small range, 5 6 7 7 1 1 1 1 2 3 4 5 5 
                if (target == A[mid]) {
                    return true;
                } else if (target > A[mid] && target <= A[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else { // mid in larger range, 5 6 7 7 8 9 9 9 9 9 4 4 5 5 
                if (target == A[mid]) {
                    return true;
                } else if (target >= A[i] && target < A[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return false;
    }
}
