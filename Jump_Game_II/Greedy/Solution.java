public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) { 
            return 0;
        }
	int i = 0;
	int steps = 0;
	while (i + A[i] < A.length - 1) {
		int pIndex = i; // pIndex, the next most promising index
		for (int j = i; j <= i + A[i] && j <= A.length - 1; ++j) {
			if (j + A[j] > pIndex + A[pIndex]) {
				pIndex = j;
			}
		}
		if (i == pIndex) {
			return -1;
		}
		i = pIndex;
		++steps;
	}
	return steps + 1;
    }

	public static void main(String args[]) {
	/*	int [] A = new int[25000];
		for (int i = 0; i < A.length; ++i) {
			A[i] = 25000 - i;
		}
	*/
	//	int [] A = new int []{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		int [] A = new int []{0,0,6};
		System.out.println(new Solution().jump(A));
	}
}
