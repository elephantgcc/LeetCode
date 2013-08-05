public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        s = s.replaceAll("10", "A").replaceAll("20", "B");
        if (s.indexOf("0") != -1) { // invalid 0
            return 0;
        }
        if (s.length() == 0) {
            return 0;
        }
        
        return numDecodingsCore(s);
    }
    
    private int numDecodingsCore(String s) {

		int N = s.length();
		int [] dp = new int [N];
		dp[0] = 1;
		for (int i = 1; i < N; ++i) {
			if (s.charAt(i - 1) == 'A' || s.charAt(i- 1) == 'B'
					|| s.charAt(i) == 'A' || s.charAt(i) == 'B') {
				dp[i] = dp[i - 1];
			} else {
				int twoCand = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
				if (twoCand >= 11 && twoCand <= 26) {
					if (i == 1) {
						dp[i] = 2;
					} else {
						dp[i] = dp[i - 2] + dp[i - 1];
					}
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}

		return dp[N - 1];
    }

	public static void main(String args[]) {
		String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().numDecodings(s));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
