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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || k<=1)
  		return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		int index = 0;
		while (head != null) {
			index++;
			if (index % k == 0) {
				cur = reverse(cur, head.next);
				head = cur.next;
			} else
				head = head.next;
		}
		return dummy.next;
	}
	public ListNode reverse(ListNode begin, ListNode end) {
		ListNode last = begin.next;
		ListNode cur = last.next;
		while (cur != end) {
			last.next = cur.next;
			cur.next = begin.next;
			begin.next = cur;
			cur = last.next;
		}
		return last;
	}
}
