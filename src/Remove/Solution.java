package Remove;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		if (head.next == null && n == 1)
			return null;
		int Firstindex = 1;
		ListNode ppNode = head;
		ListNode pNode = head;
		ListNode beforeNode = new ListNode(0);
		beforeNode.next = head;
		while (ppNode.next != null) {
			ppNode = ppNode.next;
			Firstindex++;
			if (Firstindex > n) {
				pNode = pNode.next;
				beforeNode = beforeNode.next;;
			}
		}
		ListNode delNode = pNode;
		ListNode nextNode = pNode.next;
		//System.out.print(delNode.val + "; ");
		if (nextNode != null) {

			System.out.print(nextNode.val + "; ");
			delNode.val = nextNode.val;
			delNode.next = nextNode.next;
		} else {

			beforeNode.next = null;
		}
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);

		ListNode head2 = new ListNode(3);
		head.next = head1;
		head1.next = head2;
		int n = 1;
		ListNode ans = new Solution().removeNthFromEnd(head, n);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}

}
