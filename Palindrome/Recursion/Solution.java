import java.util.*;

public class Solution {
	public ArrayList<ArrayList<String>> partition (String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s.length() == 0) {
			return result;
		} else if (s.length() == 1) {
			ArrayList<String> newForm = new ArrayList<String>();
			newForm.add(s);
			result.add(newForm);
			return result;
		} else {
			if (isPalindrome(s)) {
				ArrayList<String> newForm = new ArrayList<String>();
				newForm.add(s);
				result.add(newForm);
			}
			for (int i = 1; i < s.length(); ++i) {
				String prefix = s.substring(0, i);
				if (isPalindrome(prefix)) {
					String suffix = s.substring(i);
					ArrayList<ArrayList<String>> suffix_result = partition(suffix);
					if (suffix_result.size() == 0) {
						continue;
					} else {
						for (int j = 0; j < suffix_result.size(); ++j) {
							ArrayList<String> newForm = new ArrayList<String>();
							newForm.add(prefix);
							newForm.addAll(suffix_result.get(j));
							result.add(newForm);
						}
					}
				}
			}
			return result;
		}
	}

	private boolean isPalindrome(String s) {
		boolean flag = true;
		for ( int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}


	public static void main(String args[]) {
		ArrayList<ArrayList<String>> result = new Solution().partition("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj");
		System.out.println(result);
	}

}
