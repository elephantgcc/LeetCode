import java.util.*;

public class Solution {
	public int minCut(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}

		int N = s.length();
		int[][] table = new int[N][];
		for (int i = 0; i < N; ++i) {
			table[i] = new int[N];
		}

		for (int gap = 1; gap <= N - 1; ++gap) {
			for (int i = 0; i + gap <= N - 1; ++i) {
				if (isPalindrome(s.substring(i, i + gap + 1))) {
					table[i][i + gap] = 0;
					continue;
				} else {
					int min = gap;
					for (int j = i; j <= i + gap - 1; ++j) {
						int sum = table[i][j] + table[ j + 1][i + gap] + 1;
						if (sum < min) {
							min = sum;
						}
					}
					table[i][i + gap] = min;
				}
			}
		}
/*
		for ( int i = 0; i < N; ++i) {
			for ( int j = 0; j < N; ++j) {
				if (table[i][j] < 10) {
					System.out.print( " " + table[i][j] + " ");
				} else {
					System.out.print(table[i][j] + " ");
				}
			}
			System.out.println();
		}
*/
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
		System.out.println(new Solution().minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
					
				
				
