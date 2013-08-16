public class Solution {
    public boolean isMatch(String s, String p) {
        p = p.replaceAll("\\*+", "*");
        int P = p.length();       
        int S = s.length();
        if (P == 0) {
           return  S == 0;
        } else if (S == 0) {
           return p.equals("*");
        } // below P > 0 and S > 0

        boolean[] array = new boolean [S + 1];
        array[0] = true; // ^ matches ^
        int firstMatch = 0;

        for (int i = 1; i <= P; ++i) {
			if (p.charAt(i - 1) == '*') {
				for (int x = firstMatch + 1; x <= S; ++x) {
					array[x] = true;
				}
			} else {
				int match = -1;
				for (int j = S; j > firstMatch; --j) {
					array[j] = (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) && array[j - 1];
					if (array[j]) {
						match = j;
					}
				}
				if (match == -1) {
					return false;
				} else {
					firstMatch = match;
				}
			}
        }
        return array[S];
    }

	public static void main(String args[]) {
		String s = "";
		for (int i = 0; i < 30000; ++i) {
			s += "a";
		}
		s = "aaaaa" + s + "aaaaa";
		String p = "*" + s + "*";
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().isMatch(s, p));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
		
}
