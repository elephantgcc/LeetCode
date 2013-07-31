import java.util.*;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = root;
		while (st.size() > 0 || node != null) {
			if (node != null) {
				st.push(node);
				node = node.left;
			} else {
				node = st.pop();
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
    }
}
