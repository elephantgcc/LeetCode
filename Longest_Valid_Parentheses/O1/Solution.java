import java.util.*;

public class Solution {

	class Node {
		public char c;
		public int index;
		public Node(char c, int index) {
			this.c = c;
			this.index = index;
		}
	}

    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}
		int maxLen = 0;
		Stack<Node> st = new Stack<Node>();
		st.push(new Node(')', -1));
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				st.push(new Node('(', i));
			} else {
				if (st.peek().c == '(') {
					st.pop();
					maxLen = Math.max(maxLen, i - st.peek().index);
				} else {
					st.push(new Node(')', i));
				}
			}
		}
		return maxLen;
    }

	public static void main(String args[]) {
		String s = "()()";
		System.out.println(new Solution().longestValidParentheses(s));
	}
}
