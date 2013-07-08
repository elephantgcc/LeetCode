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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode node1 = l1, node2 = l2;
		boolean decimal = false;

		ListNode l3 = new ListNode(-1);
		ListNode iter = l3;

		while (node1 != null || node2 != null) {
			int val = 0;
			if (node1 != null) {
				val += node1.val;
				node1 = node1.next;
			}
			if (node2 != null) {
				val += node2.val;
				node2 = node2.next;
			}
			if (decimal) {
				++val;
				decimal = false;
			}
			if (val >= 10) {
				val -= 10;
				decimal = true;
			}
			iter.next = new ListNode(val);
			iter = iter.next;
		}

		if (decimal) {
			iter.next = new ListNode(1);
		}

		l3 = l3.next;
		return l3;
	}

	public static void main(String args[]) {
		ListNode l1 = new ListNode(5);
		ListNode l11 = new ListNode(4);
		ListNode l111 = new ListNode(9);
		l1.next = l11;
		l11.next = l111;
		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(4);
		ListNode l222 = new ListNode(9);
		l2.next = l22;
		l22.next = l222;
		
		ListNode l3 = new Solution().addTwoNumbers(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}
}
