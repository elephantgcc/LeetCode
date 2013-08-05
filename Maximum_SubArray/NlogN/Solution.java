public class Solution {

	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		return maxSubArray(A, 0, A.length - 1);
	}

    public int maxSubArray(int[] A, int start, int end) {

		if (end - start == 0) { // length 1
			return A[start];
		} else if (end - start == 1) { // lengh 2
			return Math.max(Math.max(A[start], A[end]), A[start] + A[end]);
		}
		int mid = start + (end - start) / 2;
		int sumLeft = 0;
		int maxLeft = 0;
		int i = mid - 1;
		while (i >= start) {
			sumLeft += A[i];
			if (sumLeft > maxLeft) {
				maxLeft = sumLeft;
			}
			--i;
		}
		int sumRight = 0;
		int maxRight = 0;
		int j = mid + 1;
		while (j <= end) {
			sumRight += A[j];
			if (sumRight > maxRight) {
				maxRight = sumRight;
			}
			++j;
		}
		int sum = maxLeft + A[mid] + maxRight;

		return Math.max(Math.max(
							maxSubArray(A, start, mid - 1),
							maxSubArray(A, mid + 1, end)),
							sum
						);
    }

	public static void main(String args[]) {
		int [] A = new int [] {1,2,-1,-2,2,1,-2,1,4,-5,4};
		System.out.println(new Solution().maxSubArray(A));
	}
}
