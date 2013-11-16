import java.util.*;

public class Solution {
	public int threeSumClosest(int[] num, int target) {

		int gap = Integer.MAX_VALUE;
		int result = 0;

		Arrays.sort(num);
		int i = 0;
		while (i <= num.length - 3) {
			int j = i + 1;
			int k = num.length - 1;
			
			while (j < k - 1) {
				int gapCur = (int)Math.abs(num[i] + num[j] + num[k] - target);
				int gapLeftMove = (int)Math.abs(num[i] + num[j + 1] + num[k] - target);
				int gapRightMove = (int)Math.abs(num[i] + num[j] + num[k - 1] - target);
				if (gapCur < gapLeftMove && gapCur < gapRightMove) {
					break;
				} else {
					if (gapLeftMove < gapRightMove) {
						++j;
					} else {
						--k;
					}
					// if we change this block into:
					//
					// if (gapLeftMove <= gapRightMove) {
					//	++j;
					//} else {
					//	--k;
					//}
					//
					// there will be a bug: 1,2,2,3,3; t=0
					//                      i j     k
					//
					// For the current version:
					// The reason why the current version works, is that the sorting is assending,
					// so that "<" is OK.
					// and by accident, the current version will solve this example:
					// 1, 2, 2, 3, 3; t = 100
					// i  j        k
					// although this step we should ++j, instead of the current --k
					// however, the fianl answer will always be the most right three numbers,
					// so this bug is hidden.
					
				}
			}
			
			int sum = num[i] + num[j] + num[k];
			if (Math.abs(sum - target) < gap) {
				result = sum;
				gap = (int)Math.abs(sum - target);
			}
			++i;
		}
		return result;
	}

	public static void main(String args[]) {
		int [] num = new int [] {4,0,5,-5,3,3,0,-4,-5};
		System.out.println(new Solution().threeSumClosest(num, -2));
	}
}
