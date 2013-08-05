/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return;
        }
        
        TreeLinkNode hh = new TreeLinkNode(-1); // queue
        TreeLinkNode end = hh;
        end.next = root;
        end = end.next;
        int count = 0;
        int numLevelNode = 1;
        
        while (hh.next != null) { // queue.size() != 0
            TreeLinkNode node = hh.next;
            hh.next = hh.next.next;
            if (hh.next == null) {
                end = hh;
            }
            ++count;
            if (count == numLevelNode) {
                node.next = null;
                count = 0;
                numLevelNode *= 2;
            }
            if (node.left != null) {
                end.next = node.left;
                end = end.next;
            }
            if (node.right != null) {
                end.next = node.right;
                end = end.next;
            }
        }
    }
}
