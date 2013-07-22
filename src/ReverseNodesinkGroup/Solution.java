package ReverseNodesinkGroup;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return head;
		if (k <= 1)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		int index = 0;
		while (cur != null && head != null) {
			index++;
			if (index % k == 0) {
				cur = reverse(cur, head.next);
				head = cur.next;
			} else
				head = head.next;
		}

		return dummy.next;
	}

	public ListNode reverse(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode cur = last.next;
		while (cur != next) {
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;

			cur = last.next;
		}
		return last;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		Solution su = new Solution();
		System.out.println(su.reverseKGroup(l1, 2));
	}

}
