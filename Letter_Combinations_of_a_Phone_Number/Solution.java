import java.util.*;

public class Solution {

	static HashMap<Character, String> table = null;
	static {
		table = new HashMap<Character, String>();
		table.put('2', "abc");
		table.put('3', "def");
		table.put('4', "ghi");
		table.put('5', "jkl");
		table.put('6', "mno");
		table.put('7', "pqrs");
		table.put('8', "tuv");
		table.put('9', "wxyz");
	}

	public ArrayList<String> letterCombinations(String digits) {

		HashSet<String> result = new HashSet<String>();
		if (digits.length() == 0) {
			result.add("");
			ArrayList<String> res = new ArrayList<String>();
			res.addAll(result);
			return res;
		}
		if (digits.charAt(0) >= '2' && digits.charAt(0) <= '9') {
			String head = table.get(digits.charAt(0));
			ArrayList<String> suffixResults = letterCombinations(digits.substring(1));
			for (int i = 0; i < head.length(); ++i) {
				for (String s : suffixResults) {
					result.add(table.get(digits.charAt(0)).charAt(i) + s);
				}
			}
		} else {
			return letterCombinations(digits.substring(1));
		}
		ArrayList<String> res = new ArrayList<String>();
		res.addAll(result);
		return res;	
	}

	public static void main(String args[]) {
		System.out.println(new Solution().letterCombinations("331013"));
	}
}
