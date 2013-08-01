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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        
        if (root.left != null) {
            if (root.left.val <= min || root.left.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val >= max || root.right.val <= root.val) {
                return false;
            }
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
