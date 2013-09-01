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
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head==null || head.next==null)
			return head;
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode pre = head;
		ListNode cur = head;
		while (pre != null && pre.next != null) {
			while (pre.next != null && pre.val == pre.next.val)
				pre = pre.next;
			if (pre == cur) { 
				tail.next = cur;
				tail = tail.next;
			}
			cur = pre.next;
			pre = pre.next;
		}
		tail.next = pre; 
		return dummy.next; 
    }
}
