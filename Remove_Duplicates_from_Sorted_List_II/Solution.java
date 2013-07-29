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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode hh = new ListNode(-1);
        hh.next = head;
        
        ListNode p = hh;
        ListNode q = p.next;
        
        while (q != null) {
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                p.next = q.next;
                q = p.next;
            } else {
                p = p.next;
                q = p.next;
            }
        }
        
        return hh.next;
    }
}
