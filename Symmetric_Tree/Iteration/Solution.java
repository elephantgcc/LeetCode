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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftStack.push(root);
        rightStack.push(root);
        while (leftStack.size() > 0 && rightStack.size() > 0) {
            TreeNode leftNode = leftStack.pop();
            TreeNode rightNode = rightStack.pop();
            if (leftNode == null && rightNode == null) {
                continue;
            } else if (leftNode == null && rightNode != null
                    || leftNode != null && rightNode == null
                    || leftNode.val != rightNode.val) {
                return false;
            } else {
                leftStack.push(leftNode.right);
                leftStack.push(leftNode.left);
                rightStack.push(rightNode.left);
                rightStack.push(rightNode.right);
            }
        }
        return leftStack.size() == 0 && rightStack.size() == 0;
    }
}
