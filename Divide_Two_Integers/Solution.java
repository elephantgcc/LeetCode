public class Solution {
	public int divide(int dividend, int divisor) {
        	boolean minus = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		dividend = dividend < 0 ? dividend : -dividend; // all working in negatives
		divisor = divisor < 0 ? divisor : -divisor;
		int result = 0;
		while (dividend <= divisor) {
			int power = 0;
			while ( power <= 31 && (divisor << (power + 1)) < 0 && (divisor << (power + 1)) >= dividend) {
				++power;
			}
			result -= (1 << power);
			dividend -= (divisor << power);
		}
		return minus ? result : -result;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().divide(2147483647, 3));
	}
}
