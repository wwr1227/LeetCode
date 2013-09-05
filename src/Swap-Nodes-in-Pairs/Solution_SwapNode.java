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
   public ListNode swapPairs(ListNode head) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;

		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode tail = newHead;
		ListNode cur = head;
		ListNode nextPair = null;
		while (cur != null && cur.next != null) {
			nextPair = cur.next.next;
			cur.next.next = tail.next;
			tail.next = cur.next;
			cur.next = nextPair;
			tail = cur;
			cur = nextPair;
		}
		return newHead.next;
	}
}
