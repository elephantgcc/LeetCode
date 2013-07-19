public class Solution {
    public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return (A[0] >= target ? 0 : 1);
		}
				
		int i = 0, j = A.length - 1;
		while (i < j - 1) {
			int k = (i + j) / 2;
			if (target < A[k]) {
				j = k;
			} else if (target > A[k]) {
				i = k;
			} else {
				return k;
			}
		}
		if (target <= A[i]) {
			return i;
		} else if (target > A[i] && target <= A[j]) {
			return j;
		} else {
			return j + 1;
		}
    }

	public static void main(String args[]) {
		int [] num = new int [] {1, 3, 4, 5};
		System.out.println(new Solution().searchInsert(num, 2));
		System.out.println(new Solution().searchInsert(num, 0));
		System.out.println(new Solution().searchInsert(num, 1));
		System.out.println(new Solution().searchInsert(num, 7));
	}
}
