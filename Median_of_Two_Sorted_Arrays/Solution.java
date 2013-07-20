public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {

		
        int N = A.length + B.length;
		if (N % 2 != 0) {
			return findKth(A, 0, B, 0, N / 2 + 1);
		} else {
			return (findKth(A, 0, B, 0, N / 2) + findKth(A, 0, B, 0, N / 2 + 1)) / 2.0;
		}
    }

	public int findKth(int A[], int m, int B[], int n, int k) {

		if (A.length - m > B.length - n) {
			return findKth(B, n, A, m, k);
		}

		if (m == A.length) {
			return B[n + k - 1];
		}

		if (k == 1) {
			return Math.min(A[m], B[n]);
		}

		int pa = Math.min(m + k / 2 - 1, A.length - 1);
		int pb = n + (k - (pa - m + 1)) - 1;
		if (A[pa] < B[pb]) {
			return findKth(A, pa + 1, B, n, k - (pa - m + 1));
		} else if (A[pa] > B[pb]) {
			return findKth(A, m, B, pb + 1, k - (pb - n + 1));
		} else {
			return A[pa];
		}
	}

	public static void main(String args[]) {
		int [] A = new int[] {};
		int [] B = new int[] {1};
		System.out.println(new Solution().findMedianSortedArrays(A, B));
	}
}
