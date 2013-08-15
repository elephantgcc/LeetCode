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

    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
    	ArrayList<TreeNode> badNodes = new ArrayList<TreeNode>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        ArrayList<TreeNode> window = new ArrayList<TreeNode>();
		window.add(new TreeNode(Integer.MIN_VALUE));
        while (st.size() > 0 || node != null) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
				window.add(node);
                if (window.size() == 3) {
                    if (window.get(0).val < window.get(1).val && window.get(1).val > window.get(2).val) {
                        badNodes.add(window.get(1)); //bad e.g. 3, 7, 5
                    } else if (window.get(0).val > window.get(1).val && window.get(1).val < window.get(2).val) {
                        badNodes.add(window.get(1)); //bad e.g. 6, 4, 8
                    }
                    window.remove(0);
                    if (badNodes.size() == 3) {
                        break;
                    }
                }
                node = node.right;
            }
        }
		window.add(new TreeNode(Integer.MAX_VALUE));
        if (window.get(0).val < window.get(1).val && window.get(1).val > window.get(2).val) {
            badNodes.add(window.get(1)); //bad e.g. 3, 7, 5
        } else if (window.get(0).val > window.get(1).val && window.get(1).val < window.get(2).val) {
            badNodes.add(window.get(1)); //bad e.g. 6, 4, 8
        }
        int temp = badNodes.get(0).val;
        badNodes.get(0).val = badNodes.get(badNodes.size() - 1).val;
        badNodes.get(badNodes.size() - 1).val = temp;
    }
}
