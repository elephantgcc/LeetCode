public class Solution {
	public int atoi(String str) {
        	if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		boolean minus = false;
		if (str.charAt(0) == '-') {
			str = str.substring(1);
			minus = true;
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}
		int result = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) > '9' || str.charAt(i) < '0') {
				return minus ? -result : result;
			}
			if (result > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10) {
				if (minus) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			} else {
				result = result * 10 + (str.charAt(i) - '0');
			}
		}
		return minus ? -result : result;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().atoi("10211049457"));
	}
}
