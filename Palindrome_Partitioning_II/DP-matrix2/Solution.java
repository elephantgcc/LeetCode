import java.util.*;

public class Solution {
	public int minCut(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}
		
		int N = s.length();
		
		long t1 = System.currentTimeMillis();
		boolean [][] isPal = new boolean [N][N];
		for (int i = 0; i < N; ++i) {
			isPal[i][i] = true;
			if (i + 1 < N) {
				isPal[i + 1][i] = true;
			}
		}
		for (int lastRow = N - 2; lastRow >= 0; --lastRow) {
			for (int i = 0; i <= lastRow; ++i) {
				int j = i + N - 1 - lastRow;
				if (s.charAt(i) == s.charAt(j)) {
					isPal[i][j] = isPal[i + 1][j - 1];
				} else {
					isPal[i][j] = false;
				}
			}
		}
		long t2 = System.currentTimeMillis();
/*
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int x = isPal[i][j] ? 1 : 0;
				System.out.print(x + " ");
			}
			System.out.println();
		}
*/
		System.out.println("isPal time = " + (t2 - t1));

		int[][] table = new int[N][N];
		for (int lastRow = N - 2; lastRow >= 0; --lastRow) {
			for (int i = 0; i <= lastRow; ++i) {
				int j = i + N - 1 - lastRow;
				if (isPal[i][j]) {
					table[i][j] = 0;
					continue;
				}
				int min = j - i;
				for (int k = i; k < j; ++k) {
					int sum = table[i][k] + table[k + 1][j] + 1;
					if (sum < min) {
                                        	min = sum;
                                        }
				}
				table[i][j] = min;
			}
		}
		return table[0][ N - 1];
	}

	private boolean isPalindrome(String s) {
		boolean flag = true;
		for ( int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				flag = false;
				break;
			}
		}
	
		return flag;
	}

	public static void main(String args[]) {
		long start = System.currentTimeMillis();

		//System.out.println(new Solution().minCut("abbabbba"));
		System.out.println(new Solution().minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
					
				
				
