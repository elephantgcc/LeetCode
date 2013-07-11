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

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		maxPathSumCore(root);
		return maxSum;
	}

	private int maxPathSumCore(TreeNode root) {
		int maxNode = Integer.MIN_VALUE;
		if (root == null) {
			return maxNode;
		}
		int left = maxPathSumCore(root.left);
		int right = maxPathSumCore(root.right);

		int leftRoot = left + root.val;
		int rootRight = root.val + right;
		int leftRootRight = left + root.val + right;

		if (left == Integer.MIN_VALUE) {
			leftRoot = Integer.MIN_VALUE;
			leftRootRight = Integer.MIN_VALUE;
		}
		if (right == Integer.MIN_VALUE) {
			leftRootRight = Integer.MIN_VALUE;
			rootRight = Integer.MIN_VALUE;
		}

		maxNode = getMax(leftRoot, rootRight, root.val);
		maxSum = getMax(maxSum, maxNode, leftRootRight);
		//System.out.println("root = " + root.val + "\t" + "maxSum = " + maxSum);
		return maxNode;
	}

	private int getMax(int ... vals) {
		int max = Integer.MIN_VALUE;
		for (int val : vals) {
			max = Math.max(max, val);
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
