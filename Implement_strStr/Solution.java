public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle.length() == 0) {
            return haystack;
        } else if (needle.length() > haystack.length()) {
            return null;
        }

        int [] next = makeNextEfficient(needle);

        int i = 0;
        while (i <= haystack.length() - needle.length()) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                ++i;
                continue;
            }
            int j = 1;
            for (; j < needle.length(); ++j) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return haystack.substring(i);
            }
            i += j - next[j - 1];
        }
        return null;
    }

	private int [] makeNextEfficient(String pattern) {
        int [] next = new int [pattern.length()];
        next[0] = 0;
        for (int i = 1; i < pattern.length(); ++i) {
            int k = next[i - 1];
            while (pattern.charAt(k) != pattern.charAt(i) && k > 0) {
                k = next[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(i)) {
                next[i] = k + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

	public static void main(String args[]) {
		String haystack = "ababbaba";
		String needle = "aba";
		System.out.println(new Solution().strStr(haystack, needle));
	}

}
