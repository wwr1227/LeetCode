//Time complexity:O(n)
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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null|| head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode after = newHead;
        ListNode cur = head;
        ListNode prev = head;
        while(prev!=null){
            while(prev.next!=null && prev.val == prev.next.val)
                prev = prev.next;
            if (prev == cur){
                after.next = cur;
                after = after.next;
            }
            cur = prev.next;
            prev = prev.next;
        }
        after.next = null;
        return newHead.next;
    }
}
