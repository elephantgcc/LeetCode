import java.util.*;

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (start.length() == 0 || start.equals(end)) {
            return 0;
        }

        if (isOneStep(start, end)) {
            return 2;
        }
        
        HashSet<String> reachable = new HashSet<String>();
        for (String node : dict) {
            if (isOneStep(start, node)) {
                reachable.add(node);
            }
        }
        if (reachable.size() == 0) {
            return 0;
        }
        dict.removeAll(reachable);
        int len = Integer.MAX_VALUE;
        boolean hasGood = false;
        for (String cand : reachable) {
            int next = ladderLength(cand, end, dict);
            if (next != 0) {
                len = Math.min(len, next + 1);
                hasGood = true;
            }
        }
        dict.addAll(reachable);
        if (hasGood) {
            return len;
        } else {
            return 0;
        }
    }
    
    private boolean isOneStep(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diff;
            }
        }
        return diff == 1;
    }

	public static void main(String args[]) {

		String start = "red";
		String end = "tax";
		String[] dictArray = new String[] {"ted","tex","red","tax","tad","den","rex","pee"};

		HashSet<String> dict = new HashSet<String>();
		for (String s: dictArray) {
			dict.add(s);
		}
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().ladderLength(start, end, dict));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
