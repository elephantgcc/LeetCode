import java.util.*;

public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
        
		HashSet<ArrayList<String>> result = generateParenthesisCore(n);
		ArrayList<String> res = new ArrayList<String>();
		for (ArrayList<String> list : result) {
			String str = "";
			for (String element : list) {
				str += element;
			}
			res.add(str);
		}
		return res;
	}

	private HashSet<ArrayList<String>> generateParenthesisCore(int n) {
		HashSet<ArrayList<String>> result = new HashSet<ArrayList<String>>();
		if (n <= 0) {
			ArrayList<String> list = new ArrayList<String>();
			result.add(list);
			return result;
		}
		
		HashSet<ArrayList<String>> prev = generateParenthesisCore(n - 1);
		for (ArrayList<String> list : prev) {
			ArrayList<String> listNew = (ArrayList<String>)list.clone();
			listNew.add(0, "()");
			result.add(listNew);
			listNew = (ArrayList<String>)list.clone();
			listNew.add("()");
			result.add(listNew);
			for (int len = 1; len <= list.size(); ++len) {
				for (int start = 0; start <= list.size() - len; ++start) {
					listNew = (ArrayList<String>)list.clone();
					String combine = "";
					for (int j = start; j < start + len;++j) {
						combine += list.get(j);
						listNew.remove(start);
					}
					combine = "(" + combine + ")";
					listNew.add(start, combine);
					result.add(listNew);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().generateParenthesis(0));
		System.out.println(new Solution().generateParenthesis(1));
		System.out.println(new Solution().generateParenthesis(2));
		System.out.println(new Solution().generateParenthesis(3));
		System.out.println(new Solution().generateParenthesis(4));
		System.out.println(new Solution().generateParenthesis(5));
	}
}
