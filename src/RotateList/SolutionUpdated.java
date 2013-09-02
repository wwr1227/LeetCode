//O(n)
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
        if(n<=0 || head==null)
            return head;
        int len = 0;
        ListNode node = head;
        while (node!=null) {
            len += 1;
            node = node.next;
        }
        if (n >= len) 
            n %= len;
        if(n==0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<len-1;i++)
            fast=fast.next;
        for(int i=0;i<len-1-n;i++)
            slow=slow.next;
    
        ListNode dummy = slow.next;
        slow.next=null;
        fast.next=head;
        return dummy;
    }
}
