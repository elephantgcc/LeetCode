public class Solution {
	public String longestCommonPrefix(String[] strs) {

		if (strs == null) {
			return null;
		}
		if (strs.length == 0) {
			return "";
		}

		int len = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].length() < len) {
				len = strs[i].length();
			}
		}

		long t1 = System.currentTimeMillis();
		int count = 0;
		int col = 0;
		boolean exceeded = false;
		for (; col < len; ++col) {
			boolean colEqual = true;
			for (int row = 0; row < strs.length; ++row) {
				++count;
				if (strs[row].charAt(col) != strs[0].charAt(col)) {
					colEqual = false;
					break;
				}
			}
			if (!colEqual) {
				break;
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println("for = " + (t2 - t1));
		System.out.println("count = " + count);
		return strs[0].substring(0, col);
	}

	public static void main(String args[]) {
		String [] strs = new String[2000];
		for (int i = 0; i < 2000; ++i) {
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
