import java.util.*;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function

		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0) {
			return result;
		}

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			String sorted = getSortedStr(s);
			if (!map.containsKey(sorted)) {
				ArrayList<String> cell = new ArrayList<String>();
				cell.add(s);
				map.put(sorted, cell);
			} else {
				ArrayList<String> cell = map.get(sorted);
				cell.add(s);
			}
		}

		for (String sorted : map.keySet()) {
			if (map.get(sorted).size() > 1) {
				for (String s : map.get(sorted)) {
					result.add(s);
				}
			}
		}

		return result;
    }

	private String getSortedStr(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}
		char[] elements = new char[s.length()];
		for (int i = 0; i < s.length(); ++i) {
			elements[i] = s.charAt(i);
		}
		Arrays.sort(elements);
		String result = "";
		for (char c : elements) {
			result += c;
		}
		return result;
	}

	public static void main(String args[]) {
		String[] A = new String [] {"ab", "ba", "aa", "bbb", "aa"};
		System.out.println(new Solution().anagrams(A));
	}
}
