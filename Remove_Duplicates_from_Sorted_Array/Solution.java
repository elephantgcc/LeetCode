public class Solution {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int i = 0, j = 0;
		while (true) {
			while( j < A.length && A[j] == A[i]) {
				++j;
			}
			if (j == A.length) {
				break;
			}
			++i;
			A[i] = A[j];
		}
        	return i + 1;
	}

	public static void main(String args[]) {
		int[] array = new int[] {1, 1, 2, 2, 3};
		int len = new Solution().removeDuplicates(array);
		System.out.println("len = " + len);
		for (int i = 0; i < len; ++i) {
			System.out.println(array[i]);
		}
	}
}
