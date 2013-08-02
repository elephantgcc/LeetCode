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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        root = flattenCore(root);
    }
    
    private TreeNode flattenCore(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftSubTree = flattenCore(root.left);
        TreeNode rightSubTree = flattenCore(root.right);
        
        root.left = null;
        root.right = leftSubTree;
        TreeNode leftLast = leftSubTree;
        if (leftLast != null) {
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = rightSubTree;
        } else {
            root.right = rightSubTree;
        }
        return root;
    }
}
