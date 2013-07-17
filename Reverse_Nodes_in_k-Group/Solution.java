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
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null) {
		return null;
	}
	if (k == 1) {
		return head;
	}
	ListNode top = new ListNode(-1);
	top.next = head;
	ListNode prev = top;
	ListNode p = head;
	ListNode q = p;

	for (int i = 0; i <= k - 2; ++i) {
		if (q == null) {
			break;
		}
		q = q.next;
	}

	while (q != null) {
		ListNode pp = p;
		ListNode p1 = p.next;
		ListNode p2 = p1.next;
		ListNode after = q.next;
		prev.next = q;
		p.next = after;
		while (p1 != q) {
			p1.next = p;
			p = p1;
			p1 = p2;
			p2 = p2.next;
		}
		p1.next = p;

		prev = pp;
		p = after;
		q = p;
		for (int i = 0; i <= k - 2; ++i) {
                	if (q == null) {
                        	break;
                	}
                	q = q.next;
		}
        }
	return top.next;
    }

	public static void main(String args[]) {
		ListNode [] nodes = new ListNode[2];
		for (int i = 0; i < nodes.length; ++i) {
			nodes[i] = new ListNode(i + 1);
			if (i >= 1) {
				nodes[i - 1].next = nodes[i];
			}
		}

		ListNode node = new Solution().reverseKGroup(nodes[0], 5);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
