/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int min, int max) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (min > max) {
            result.add(null);
            return result;
        }
        if (min == max) {
            TreeNode currNode = new TreeNode(min);
            result.add(currNode);
            return result;
        }
        
        ArrayList<TreeNode> rightChildren = generateTrees(min + 1, max);
        for (TreeNode child : rightChildren) {
            TreeNode currNode = new TreeNode(min);
            currNode.right = child;
            result.add(currNode);
        }
        ArrayList<TreeNode> leftChildren = generateTrees(min, max - 1);
        for (TreeNode child : leftChildren) {
            TreeNode currNode = new TreeNode(max);
            currNode.left = child;
            result.add(currNode);
        }
        for (int i = min + 1; i <= max - 1; ++i) {
            leftChildren = generateTrees(min, i - 1);
            rightChildren = generateTrees(i + 1, max);
            for (TreeNode leftChild : leftChildren) {
                for (TreeNode rightChild : rightChildren) {
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = leftChild;
                    currNode.right = rightChild;
                    result.add(currNode);
                }
            }
        }
        
        return result;
    }
}
