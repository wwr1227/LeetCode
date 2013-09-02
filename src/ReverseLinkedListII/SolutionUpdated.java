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
   public ListNode reverseBetween(ListNode head, int m, int n) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return head;
		int index = 0;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode tail = dummy;
		while (index < m-1) {
			index++;
			tail = tail.next;
			cur = cur.next;
		}
		ListNode behindM = cur;
		while (index < n) {
			index++;
			ListNode next = cur.next;
			cur.next = tail.next;
			tail.next = cur;
			cur = next;
		}
		behindM.next = cur;
		return dummy.next;
	}
}
