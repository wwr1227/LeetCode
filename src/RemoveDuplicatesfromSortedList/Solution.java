package RemoveDuplicatesfromSortedList;

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
		if (head == null)
			return head;

		ListNode nhead = head;
		while (head.next != null) {
			int val = head.next.val;
			if (val == head.val) {
				head.next = head.next.next;
			} else{
				head = head.next;
			}
			if (head == null)
				break;
		}
		return nhead;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		node1.next = node2;
		// node2.next = node3;
		Solution su = new Solution();
		System.out.println(su.deleteDuplicates(node1));
	}

}
