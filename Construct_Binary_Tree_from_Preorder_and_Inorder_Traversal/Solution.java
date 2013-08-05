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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTree(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd,
                               int[] inorder, int inBegin, int inEnd) {
        
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = inBegin;
        for (; rootIndex <= inEnd; ++rootIndex) {
            if (inorder[rootIndex] == preorder[preBegin]) {
                break;
            }
        }
        int leftEndIndex = preBegin + (rootIndex - inBegin); // leftEndIndex in preorder
        TreeNode leftSubTree = buildTree(preorder, preBegin + 1, leftEndIndex,
                                         inorder, inBegin, rootIndex - 1);
        root.left = leftSubTree;
        TreeNode rightSubTree = buildTree(preorder, leftEndIndex + 1, preEnd,
                                          inorder, rootIndex + 1, inEnd);
        root.right = rightSubTree;
        
        return root;
    }

	public static void main(String args[]) {
		int [] pre = new int [] {1, 2, 3, 4};
		int [] in  = new int [] {4, 3, 2, 1};
		new Solution().buildTree(pre, in);
	}
}
