public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) {
			return 1;
		}
		boolean neg = false;
		if (n < 0) {
			neg = true;
			n = -n;
		}
		double result = pow(x, n / 2);
		result *= result;
		if (n % 2 != 0) {
			result *= x;
		}
		return neg ? 1.0 / result : result;
    }

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().pow(0.00001, 63));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
