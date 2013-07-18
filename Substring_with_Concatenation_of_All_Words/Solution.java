import java.util.*;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (L == null || L.length == 0 || S == null || S.length() == 0) {
			return result;
		}

		HashMap<String, Integer> histogramOld = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; ++i) {
			if (!histogramOld.containsKey(L[i])) {
				histogramOld.put(L[i], 1);
			} else {
				histogramOld.put(L[i], histogramOld.get(L[i]) + 1);
			}
		}

		int numWords = L.length;
		int wordLength = L[0].length();
		int rangeLength = numWords * wordLength;
		for (int i = 0; i <= S.length() - rangeLength; ++i) {
			HashMap<String, Integer> histogramNew = new HashMap<String, Integer>();
			for (int j = 0; j < numWords; ++j) {
				String word = S.substring(i + j * wordLength, i + (j + 1) * wordLength); 
				if (!histogramNew.containsKey(word)) {
					histogramNew.put(word, 1);
				} else {
					histogramNew.put(word, histogramNew.get(word) + 1);
				}
			}
			if (histogramOld.size() != histogramNew.size()) {
				continue;
			} else {
				boolean same = true;
				for (String word: histogramOld.keySet()) {
					if (!histogramNew.containsKey(word) || histogramNew.get(word) != histogramOld.get(word)) {
						same = false;
						break;
					}
				}
				if (same) {
					result.add(i);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().findSubstring("barfoooo", new String[] {"bar", "foo"}));
	}
}
