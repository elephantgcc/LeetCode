public class Solution {
    public int[] searchRange(int[] A, int target) {
		int [] result = new int [] {-1, -1};	
		if (A == null || A.length == 0) {
			return result;
		}
		int leftMost = searchLeftMost(A, target);
		int rightMost = searchRightMost(A, target);
		result[0] = leftMost;
		result[1] = rightMost;
		return result;
    }

	private int searchLeftMost(int[] A, int target) {
		if (A.length == 1) {
			return target == A[0] ? 0 : -1;
		}
		int i = 0, j = A.length - 1;
		while (i < j - 1) {
			int k = (i + j) / 2;
			if (target < A[k]) {
				j = k - 1;
			} else if (target > A[k]) {
				i = k + 1;
			} else {
				j = k;
			}
		}			
		if (A[i] == target) {
			return i;
		} else if (A[j] == target) {
			return j;
		} else {
			return -1;
		}
	}

	private int searchRightMost(int[] A, int target) {
		if (A.length == 1) {
			return target == A[0] ? 0 : -1;
		}
		int i = 0, j = A.length - 1;
		while ( i < j - 1) {
			int k = (i + j) / 2;
			if (target < A[k]) {
				j = k - 1;
			} else if (target > A[k]) {
				i = k + 1;
			} else {
				i = k;
			}
		}
		if (A[j] == target) {
			return j;
		} else if (A[i] == target) {
			return i;
		} else {
			return -1;
		}
	}

	public static void main(String args[]) {
		int [] num = new int [] {1, 1};
		int [] result = new Solution().searchRange(num, -1);
		System.out.println(result[0] + " " + result[1]);
	}
}
