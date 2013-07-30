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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == n) {
            return head;
        }
        
        ListNode hh = new ListNode(-1);
        hh.next = head;
        
        ListNode handler = hh;
        ListNode begin = head;
        ListNode end = head;
        for (int i = 1; i <= n - m; ++i){
            end = end.next;
        }
        for (int i = 1; i <= m - 1; ++i){
            begin = begin.next;
            end = end.next;
            handler = handler.next;
        }
        handler.next = end;

        ListNode x1 = begin;
        ListNode x2 = x1.next;
        ListNode x3 = x2.next;
        ListNode after = end.next;
        
        while (x2 != after) {
            x2.next = x1;
            x1 = x2;
            x2 = x3;
            x3 = x3 == null ? null : x3.next;
        }
        
        begin.next = after;
        
        return hh.next;
    }
}
