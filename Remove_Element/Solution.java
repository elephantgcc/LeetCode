public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0, j = A.length - 1;
        while (i <= j) {
            while (j >= 0 && A[j] == elem) {
                --j;
            }
            if (i > j) {
                break;
            }
            while (i <= A.length - 1 && A[i] != elem) {
                ++i;
            }
            if (i > j) {
                break;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return j + 1;
    }

    public static void main(String args[]) {
	int [] array = new int [] {3};
	int len = new Solution().removeElement(array, 3);
	System.out.println(len);
	for (int i = 0; i < len; ++i) {
		System.out.println(array[i]);
	}
    }
}
