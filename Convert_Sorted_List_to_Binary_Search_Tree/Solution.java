/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
    	if (head == null) {
			return null;
		}
		int len = getLength(head);
		return sortedListToBST(head, len);
	}

	private TreeNode sortedListToBST(ListNode head, int len) {
		if (len <= 0) {
			return null;
		}

		int mid = (len - 1) / 2;
		ListNode hh = new ListNode(-1);
		hh.next = head;
		ListNode prev = hh; 
		ListNode curr = head;
		for (int i = 0; i < mid; ++i) {
			prev = prev.next;
			curr = curr.next;
		}
		TreeNode root = new TreeNode(curr.val);
		prev.next = null;
		int leftLen = mid;
		root.left = sortedListToBST(head, leftLen);
		int rightLen = len - (mid + 1);
		root.right = sortedListToBST(curr.next, rightLen);
		return root;
	}

	private int getLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int len = 0;
		ListNode node = head;
		while (node != null) {
			++len;
			node = node.next;
		}
		return len;
	}
}
