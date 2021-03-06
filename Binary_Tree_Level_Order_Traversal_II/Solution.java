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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> qNext = new ArrayDeque<TreeNode>();
        q.add(root);
        while (q.size() > 0) {
            ArrayList<Integer> cell = new ArrayList<Integer>();
            while (q.size() > 0) {
                TreeNode node = q.pollFirst();
                cell.add(node.val);
                if (node.left != null) {
                    qNext.add(node.left);
                }
                if (node.right != null) {
                    qNext.add(node.right);
                }
            }
            result.add(0, cell);
            q = qNext;
            qNext = new ArrayDeque<TreeNode>();
        }
        return result;
    }
}
