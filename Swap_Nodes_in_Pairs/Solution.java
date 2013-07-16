/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class Solution {
	public ListNode swapPairs(ListNode head) {
    	if (head == null) {
			return null;
		}
		ListNode top = new ListNode(-1);
		top.next = head;
		ListNode prev = top;
		ListNode p = head;
		ListNode t = p.next == null ? null : p.next;
		while (t != null) {
			p.next = t.next;
			t.next = p;
			prev.next = t;
			
			prev = p;
			p = p.next;
			if (p == null) {
				break;
			}
			t = p.next == null ? null : p.next;
		}
		return top.next;
	}

	public static void main(String args[]) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;

		ListNode node = new Solution().swapPairs(node1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
		
}
