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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inBegin, int inEnd,
                               int[] postorder, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inBegin;
        for (; rootIndex <= inEnd; ++rootIndex) {
            if (inorder[rootIndex] == postorder[postEnd]) {
                break;
            }
        }
        int firstRightIndex = postEnd - (inEnd - rootIndex);
        TreeNode leftSubTree = buildTree(inorder, inBegin, rootIndex - 1,
                                        postorder, postBegin, firstRightIndex - 1);
        root.left = leftSubTree;
        TreeNode rightSubTree = buildTree(inorder, rootIndex + 1, inEnd,
                                          postorder, firstRightIndex, postEnd - 1);
        root.right = rightSubTree;
        
        return root;
    }
}
