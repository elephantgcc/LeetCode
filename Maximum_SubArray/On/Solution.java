public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
			return 0;
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; ++i) {
			sum += A[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
    }

	public static void main(String args[]) {
		int [] A = new int [] { 2, -1, 2, -4, 3, -1, 2, 2};
		System.out.println(new Solution().maxSubArray(A));
	}
}
