public class Solution {
    public boolean isScramble(String s1, String s2) {
		if (s1.length() == 0) {
			return s1.length() == 0;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		for (int i = 1; i < s1.length(); ++i) {
			if (		(isScramble(s1.substring(0, i), s2.substring(0, i))
						&& isScramble(s1.substring(i), s2.substring(i)))
					||	(isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
						&& isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))) {
				return true;
			}
		}
        return false;
    }

	public static void main(String args[]) {
		String s1 = "great";
		String s2 = "taerg";
		System.out.println(new Solution().isScramble(s1, s2));

	}
}
