public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) { 
            return 0;
        }

        int [] result = new int[A.length];
        for (int i = A.length - 2; i >= 0; --i) {
            int candidates = A[i];
			if (candidates == 0) {
				continue;
			}
			int least = 1 + result[i + 1];
			for (int j = i + 2; j <= A.length - 1 && j <= i + candidates; ++j) {
				if (A[j] == 0 && j != A.length - 1) {
					continue;
				}
                if (1 + result[j] < least) {
                    least = 1 + result[j];
                }
            }
            result[i] = least;
        }

        return result[0] == 0 ? -1 : result[0];

    }

	public static void main(String args[]) {
		int [] A = new int[25000];
		for (int i = 0; i < A.length; ++i) {
			A[i] = 25000 -i;
		}

//		int [] A = new int []{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		//int [] A = new int []{0,0,6};
		System.out.println(new Solution().jump(A));
	}
}
