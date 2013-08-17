/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0 || head == null) {
            return head;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            ++count;
        }
        if (n == count) {
            return head;
        } else if (n > count) {
            n = n % count;
        }
        ListNode hh = new ListNode(-1);
        hh.next = head;
        ListNode prev = head;
        ListNode curr = head;
        for (int i = 1; i <= n; ++i) {
            curr = curr.next;
        }
        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }
        curr.next = hh.next;
        hh.next = prev.next;
        prev.next = null;
        return hh.next;
    }
}
