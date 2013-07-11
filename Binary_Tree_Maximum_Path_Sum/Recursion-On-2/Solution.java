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
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		int leftSumTop = maxPathSumTop(root.left);
		int rightSumTop = maxPathSumTop(root.right);
		int leftSum = maxPathSum(root.left);
		int rightSum = maxPathSum(root.right);

		int leftMidRight = leftSumTop + root.val + rightSumTop;
		int leftMid      = leftSumTop + root.val;
		int midRight     =              root.val + rightSumTop;
		int mid          =              root.val;
		int left	 = leftSum;
		int right 	 = rightSum;

		if (leftSumTop == Integer.MIN_VALUE) {
			leftMidRight = Integer.MIN_VALUE;
			leftMid = Integer.MIN_VALUE;
		}
		if (rightSumTop == Integer.MIN_VALUE) {
			leftMidRight = Integer.MIN_VALUE;
			midRight = Integer.MIN_VALUE;
		}
		if (leftSum == Integer.MIN_VALUE) {
			left = Integer.MIN_VALUE;
		}
		if (rightSum == Integer.MIN_VALUE) {
			right = Integer.MIN_VALUE;
		}
		
		return max(leftMidRight, leftMid, midRight, mid, left, right);
	}

	public int maxPathSumTop(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}

		int leftSumTop = maxPathSumTop(root.left);
		int rightSumTop = maxPathSumTop(root.right);

		int leftMid  = leftSumTop + root.val;
		int midRight =              root.val + rightSumTop;
		int mid = root.val;

		if (leftSumTop == Integer.MIN_VALUE) {
			leftMid = Integer.MIN_VALUE;
		}
		if (rightSumTop == Integer.MIN_VALUE) {
			midRight = Integer.MIN_VALUE;
		}
		return max(leftMid, midRight, mid);
	}

	public int max(int ... vals) {
		int max = Integer.MIN_VALUE;
		for (int val : vals) {
			if (val > max) {
				max = val;
			}
		}
		return max;
	}

	public static void main(String args[]) {
		TreeNode[] nodes = new TreeNode[1000000];
		for (int i = 0; i < 1000000; ++i) {
			nodes[i] = new TreeNode(i);
		}
		for (int i = 0; i <= (1000000 - 2) / 2; ++i) {
			nodes[i].left = nodes[2 * i + 1];
			if (2 * i + 2 < 1000000) {
				nodes[i].right = nodes[2 * i + 2];
			}
		}

		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().maxPathSum(nodes[0]));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
