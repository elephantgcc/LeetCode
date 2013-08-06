import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
			return 0;
		}

		int result = 0;

		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode prev = null;
		st.push(root);
		TreeNode curr = null;
		while (st.size() > 0) {
			curr = st.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					st.push(curr.left);
				} else if (curr.right != null) {
					st.push(curr.right);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					st.push(curr.right);
				}
			} else {
				if (curr.left == null && curr.right == null) {
					int sum = 0;
					Iterator<TreeNode> iter = st.iterator();
					while (iter.hasNext()) {
						sum = 10* sum + iter.next().val;
					}
					result += sum;
				}
				st.pop();
			}
			prev = curr;
		}

		return result;
    }

	public static void main(String args[]) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node2.right = node3;

		System.out.println(new Solution().sumNumbers(node1));
	}

}
