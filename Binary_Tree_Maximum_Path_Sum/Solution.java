/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(root.val + maxPathSum(root.left) + maxPathSum(root.right),
					maxPathSum(root.left) + maxPathSum(root.right));
	}

	public static void main(String args[]) {
		TreeNode node = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node.left = node2;
		node.right = node3;
		System.out.println(new Solution().maxPathSum(node));
	}
}
