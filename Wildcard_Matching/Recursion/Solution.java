public class Solution {

	public boolean isMatch(String s, String p) {
		p = p.replaceAll("\\*+", "*");
		return isMatchCore(s, p);
	}

    public boolean isMatchCore(String s, String p) {

		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (s.length() == 0) {
			return p.length() == 0 || p.equals("*");
		}

		if (p.charAt(0) == '*') {
			while (s.length() > 0) {
				if (isMatchCore(s, p.substring(1))) {
					return true;
				}
				s = s.substring(1);
			}
			return isMatchCore(s, p.substring(1));
		} else if (p.charAt(0) == '?') {
			return isMatchCore(s.substring(1), p.substring(1));
		} else {
			if (p.charAt(0) == s.charAt(0)) {
				return isMatchCore(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}
    }

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().isMatch("baaabb", "*b**bb"));
		//System.out.println(new Solution().isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
