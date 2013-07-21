public class Solution {
    public int trap(int[] A) {

		if (A == null || A.length == 0 || A.length == 1 || A.length == 2) {
			return 0;
		}

		int i = 0, j = A.length - 1;
		int topWall = 0;
		int area = 0;
		while (i < j) {
			if (A[i] <= A[j]) {
				int curWall = A[i];
				if (curWall <= topWall) {
					area -= curWall;
				} else {
					area -= topWall;
					area += (curWall - topWall) * (j - i - 1);
					topWall = curWall;
				}
				++i;
			} else if (A[i] > A[j]) {
				int curWall = A[j];
				if (curWall <= topWall) {
					area -= curWall;
				} else {
					area -= topWall;
					area += (curWall - topWall) * (j - i - 1);
					topWall = curWall;
				}
				--j;
			}
		}
		return area;
	}

	public static void main(String args[]) {
		//int [] A = new int[] {0,1,0,1,2,1,0,1,3,2,1,2,1};
		int [] A = new int[] {7, 1};
		System.out.println(new Solution().trap(A));
	}
}
