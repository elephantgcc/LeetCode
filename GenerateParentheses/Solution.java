import java.util.*;

public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
        
		HashSet<String> result = new HashSet<String>();
		if (n <= 0) {
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		
		ArrayList<String> innerResult = generateParenthesis(n - 1);
		for (String inner : innerResult) {
			result.add("()" + inner);
			result.add(inner + "()");
			result.add("(" + inner + ")");
		}

		ArrayList<String> res = new ArrayList<String>();
		res.addAll(result);
		return res;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().generateParenthesis(3));
	}
}
