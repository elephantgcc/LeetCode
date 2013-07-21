public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) { 
            return 0;
        }

		return jumpCore(A, 0);
    }

	private int jumpCore(int[] A, int start) {

		if (start == A.length - 1) {
			return 0;
		}
		int candidates = A[start];
		if (start + candidates >= A.length - 1) {
			return 1;
		}
		int least = 1 + jumpCore(A, start + 1);
		for (int i = start + 2; i <= A.length - 1 && i <= start + candidates; ++i) {
			int cur = 1 + jumpCore(A, i);
			if (cur < least) {
				least = cur;
			}
		}
		return least;
	}

	public static void main(String args[]) {
		int [] A = new int [] {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		System.out.println(new Solution().jump(A));
	}
}
