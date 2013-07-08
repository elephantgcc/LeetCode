public class Solution {
	public int reverse(int x) {
		int y = 0;
		boolean minus = false;
		if (x < 0) {
			minus = true;
			x = -x;
		}
		while (x != 0) {
			y = y * 10 + x % 10;
			x = x / 10;
		}
		if (minus) {
			y = -y;
		}
		return y;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().reverse(123));
	}
}
