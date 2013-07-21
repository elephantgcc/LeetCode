public class Solution {
    public int firstMissingPositive(int[] A) {
		int N = A.length;
		if (N == 0) {
			return 1;
		}
		for (int i = 0; i < N; ++i) {
			if (A[i] <= 0) {
				A[i] = N + 2;
			}
		}
		for (int i = 0; i < N; ++i) {
			int index = (int)Math.abs(A[i]) - 1;
			if (index < N && A[index] > 0) {
				A[index] = -A[index];
			}
		}
		for (int i = 0; i < N; ++i) {
			if (A[i] > 0) {
				return i + 1;
			}
		}
		return N + 1;

    }

	public static void main(String args[]) {
		int [] num = {1, 1};
		System.out.println(new Solution().firstMissingPositive(num));
	}
}
