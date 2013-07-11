public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = new String();
        if(strs.length > 0)
            prefix = strs[0];
        for(int i = 1; i < strs.length; ++i) {
            String s = strs[i];
            int j = 0;
            for(; j < Math.min(prefix.length(), s.length()); ++j) {
                if(prefix.charAt(j) != s.charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    
	public static void main(String args[]) {
		String [] strs = new String[100];
		for (int i = 0; i < 100; ++i) {
			strs[i] = "";
			for (int j = 0; j < 2000; ++j) {
				strs[i] += "a";
			}
		}
		
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().longestCommonPrefix(strs));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
