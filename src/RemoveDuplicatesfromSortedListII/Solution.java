package RemoveDuplicatesfromSortedListII;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode re = new ListNode(0);
		ListNode tail = re;
		ListNode pre = head, cur = head;

		while (cur != null && cur.next != null) {
			while (cur.next != null && cur.val == cur.next.val)
				cur = cur.next;
			if (pre == cur) { // distinct value
				tail.next = pre;
				tail = tail.next;
			}
			pre = cur.next;
			cur = cur.next;
		}
		
		tail.next = cur; // add the last value
		return re.next; // dump the dummy node
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
