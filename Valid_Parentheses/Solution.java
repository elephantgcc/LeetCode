import java.util.*;

public class Solution {
	public boolean isValid(String s) {
        	Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.size() <= 0 || stack.pop() != '(') {
					return false;
				}
			} else if (c == ']') {
				if (stack.size() == 0 || stack.pop() != '[') {
					return false;
				}
			} else if (c == '}') {
				if (stack.size() == 0 || stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.size() == 0 ? true : false;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().isValid("({}[])"));
		System.out.println(new Solution().isValid("({[}])"));
		System.out.println(new Solution().isValid("]"));
	}
}
