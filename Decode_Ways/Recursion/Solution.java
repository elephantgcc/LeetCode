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
        if (s.length() == 0 || s.length() == 1) {
            return 1;
        }
        
        if (s.charAt(0) == 'A' || s.charAt(0) == 'B'
                || s.charAt(1) == 'A' || s.charAt(1) == 'B') {
            return numDecodingsCore(s.substring(1));
        } else {
            int twoCand = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            if (twoCand >= 11 && twoCand <= 26) {
                return numDecodingsCore(s.substring(1)) + numDecodingsCore(s.substring(2));
            } else {
                return numDecodingsCore(s.substring(1));
            }
        }
    }

	public static void main(String args[]) {
		String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().numDecodings(s));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
