import java.util.*;

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
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(root.val);
			result.add(path);
			return result;
		}
		
		ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum - root.val);
		for (int i = 0; i < left.size(); ++i) {
			result.add(left.get(i));
		}
		ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum - root.val);
		for (int i = 0; i < right.size(); ++i) {
			result.add(right.get(i));
		}
		for (int i = 0; i < result.size(); ++i) {
			result.get(i).add(0, root.val);
		}
		return result;
	}

	public static void main(String args[]) {



	}
}
