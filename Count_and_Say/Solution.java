public class Solution {
    public String countAndSay(int n) {

		if (n == 1) {
			return "1";
		}

		String result = "";
		String prev = countAndSay(n - 1);
		char c = prev.charAt(0);
		int count = 1;
		for (int i = 1; i < prev.length(); ++i) {
			if (prev.charAt(i) == c) {
				++count;
			} else {
				result += count + "" + c;
				c = prev.charAt(i);
				count = 1;
			}
		}
		result += count + "" +  c;
		return result;
    }

	public static void main(String args[]) {
		for (int i = 1; i <= 10; ++i) {
			System.out.println(new Solution().countAndSay(i));
		}
	}
}
