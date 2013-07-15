import java.util.*;

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
	public ListNode mergeKLists(ArrayList<ListNode> lists) {

		if (lists == null || lists.size() == 0) {
			return null;
		}

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
				new Comparator() {
					public int compare(Object o1, Object o2) {
						return ((ListNode)o1).val - ((ListNode)o2).val;
					}
				});
		for (ListNode list : lists) {
			if (list != null) {
				heap.add(list);
			}
		}
		if (heap.size() == 0) {
			return null;
		}
		ListNode head = new ListNode(-1);
		ListNode iter = head;
		while (heap.size() > 0) {
			ListNode list = heap.poll();
			iter.next = list;
			iter = iter.next;
			if (list.next != null) {
				heap.add(list.next);
			}
		}
		return head.next;
	}

	public static void main(String args[]) {
		ListNode node1 = new ListNode(-4);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		ListNode node3 = new ListNode(-3);
		ListNode node4 = new ListNode(2);
		node3.next = node4;
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(null);
		lists.add(node1);
		lists.add(node3);

		ListNode node = new Solution().mergeKLists(lists);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}
}
