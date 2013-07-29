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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return head;
        }
        
        ListNode headSmall = new ListNode(-1);
        ListNode p = headSmall;
        ListNode headBig = new ListNode(-1);
        ListNode r = headBig;
        
        ListNode q = head;
        while (q != null) {
            if (q.val < x) {
                p.next = q;
                q = q.next;
                p = p.next;
                p.next = null;
            } else {
                r.next = q;
                q = q.next;
                r = r.next;
                r.next = null;
            }
        }
        
        p.next = headBig.next;
        
        return headSmall.next;
    }
}
