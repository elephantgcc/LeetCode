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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode(-1);
        ListNode iter = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = l1;
                iter = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                iter = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            iter.next = l2;
        } else {
            iter.next = l1;
        }
        
        return head.next;
    }
}
