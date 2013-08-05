import java.util.*;

public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (start.length() == 0 || start.equals(end)) {
            return result;
        }

        if (isOneStep(start, end)) {
			ArrayList<String> cell = new ArrayList<String>();
			cell.add(start);
			cell.add(end);
			result.add(cell);
            return result;
        }
        
        HashSet<String> reachable = new HashSet<String>();
        for (String node : dict) {
            if (isOneStep(start, node)) {
                reachable.add(node);
            }
        }
        if (reachable.size() == 0) {
            return result;
        }
        dict.removeAll(reachable);
        int len = Integer.MAX_VALUE;
        boolean hasGood = false;
		ArrayList<ArrayList<ArrayList<String>>> container = new ArrayList<ArrayList<ArrayList<String>>>();
        for (String cand : reachable) {
            ArrayList<ArrayList<String>> next = findLadders(cand, end, dict);
            if (next.size() != 0) {
                len = Math.min(len, next.get(0).size() + 1);
                hasGood = true;
				container.add(next);
            }
        }
		dict.addAll(reachable);
		
        if (hasGood) {
			for (ArrayList<ArrayList<String>> next : container) {
				if (next.get(0).size() + 1 == len) {
					for (ArrayList<String> cell : next) {
						cell.add(0, start);
					}
					result.addAll(next);
				}
			}
            return result;
        } else {
            return result;
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
		System.out.println(new Solution().findLadders(start, end, dict));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
