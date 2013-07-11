public class Solution {
	public boolean isPalindrome(int x) {
        	if (x < 0) {
			return false;
		}
		int div = 0;
		while((int)(x / Math.pow(10, div)) >= 10) {
			++div;
		}
		for (int i = 0; i <= div / 2; ++i) {
			int left = (int)(x / Math.pow(10, div - i)) % 10;
			int right = (int)(x / Math.pow(10, i)) % 10;
			if (left != right) {
				return false;
			}
		}
		return true;
	}

	public static void main (String args[]) {
		System.out.println(new Solution().isPalindrome(2012222102));
	}	
}
