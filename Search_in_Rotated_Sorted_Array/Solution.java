public class Solution {
    public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int i = 0, j = A.length - 1;
		while (i < j) {
			int k = (i + j) / 2;
			if (A[i] <= A[k] && A[k] <= A[j]) { //good order
				if (target < A[k]) {
					j = k - 1;
				} else if (target > A[k]) {
					i = k + 1;
				} else {
					return k;
				}
			} else { // rotated
				if (A[k] >= A[i] && A[k] > A[j]) {
					if (target == A[k]) {
						return k;
					} else if (target >= A[i] && target < A[k]) {
						j = k - 1;
					} else {
						i = k + 1;
					}
				} else {
					if (target == A[k]) {
                        return k;
					} else if (target > A[k] && target <= A[j]) {
						i = k + 1;
					} else {
						j = k - 1;
					}
				}
			}
		}
		if (i == j) {
			return A[j] == target ? j : -1;
		} else {
			return -1;
		}
    }

	public static void main(String args[]) {
		int [] num = {4, 2};
		for (int i : num) {
			System.out.println(new Solution().search(num, i));
		}
	}
}
