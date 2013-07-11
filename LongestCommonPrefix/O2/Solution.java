public class Solution {
	public String longestCommonPrefix(String[] strs) {

		if (strs == null) {
			return null;
		}
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int col = 0;
		boolean exceeded = false;
		while (true) {
			boolean colEqual = true;
			for (int row = 0; row < strs.length; ++row) {
				if (col == strs[row].length()) {
					exceeded = true;
					break;
				}
				if (strs[row].charAt(col) != strs[0].charAt(col)) {
					colEqual = false;
					break;
				}
			}
			if (exceeded) {
				break;
			}
			if (colEqual) {
				++col;
			} else {
				break;
			}
		}
		return strs[0].substring(0, col);
	}

	public static void main(String args[]) {
		String [] strs = new String[100];
		for (int i = 0; i < 100; ++i) {
			strs[i] = "";
			for (int j = 0; j < 2000; ++j) {
				strs[i] += "a";
			}
		}
		
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().longestCommonPrefix(strs));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
