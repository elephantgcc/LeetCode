import java.util.*;

public class Solution {
	public int minCut(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return 0;
		} else {
			if (isPalindrome(s)) {
				return 0;
			}
			int min = s.length() - 1;
			for (int i = 1; i <= s.length() - 1; ++i) {
				int cut = min;
				String prefix = s.substring(0, i);
				String suffix = s.substring(i);
				if (isPalindrome(prefix)) {
					cut = 1 + minCut(suffix);
				} else {
					cut = prefix.length() + minCut(suffix); // - 1 + 1
				}
				if (cut < min) {
					min = cut;
				}
			}
			return min;
		}
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
		System.out.println(new Solution().minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
	}

}
