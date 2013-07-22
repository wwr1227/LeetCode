package MergeTwoSortedLists;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ListNode merge = new ListNode(0);
		ListNode head = merge;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				merge.next = l1;
				l1 = l1.next;
			} else {
				merge.next = l2;
				l2 = l2.next;
			}
			merge = merge.next;
		}
		if (l1 != null) {
			merge.next = l1;
		}
		if (l2 != null) {
			merge.next = l2;
		}

		return head.next;

	}
}
