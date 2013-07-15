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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode i = head;
		ListNode j = head;
		for (int x = 0; x < n; ++x) {
			j = j.next;
		}
		if (j != null) {
			while (j.next != null) {
				j = j.next;
				i = i.next;
			}
			i.next = i.next.next;
		} else {
			head = i.next;
		}
        	return head;
	}

	public static void main(String args[]) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		//node1.next = node2;
		//node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;
		ListNode node = new Solution().removeNthFromEnd(node1, 1);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
