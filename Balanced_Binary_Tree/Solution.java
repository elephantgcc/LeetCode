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
    
    public boolean isBalanced(TreeNode root) {
        return isBalancedWithHeight(root) >= 0;
    }
    
    private int isBalancedWithHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
       
		int leftHeight = isBalancedWithHeight(root.left);
		if (leftHeight < 0) {
			return -1;
		}
		int rightHeight = isBalancedWithHeight(root.right);
		if (rightHeight < 0) {
			return -1;
		}
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
       
		return Math.max(leftHeight + 1, rightHeight + 1); 
    }
    
	private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode leftSubTree = sortedArrayToBST(num, start, mid - 1);
        root.left = leftSubTree;
        TreeNode rightSubTree = sortedArrayToBST(num, mid + 1, end);
        root.right = rightSubTree;
        
        return root;
    }

	public static void main(String args[]) {

		int[] num = new int [100000];
		for (int i = 0; i < num.length; ++i) {
			num[i] = i;
		}
		TreeNode root = sortedArrayToBST(num, 0, num.length - 1);
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().isBalanced(root));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}	
}
