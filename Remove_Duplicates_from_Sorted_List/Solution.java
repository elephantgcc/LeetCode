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
        
        ListNode p = head;
        ListNode q = head.next;
        
        while (q != null) {
            if (q.val == p.val) {
                q = q.next;
            } else {
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        p.next = null;
        
        return head;
    }
}
