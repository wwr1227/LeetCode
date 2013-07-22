package ReverseLinkedListII;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || m == n)
			return head;
		ListNode nhead = new ListNode(0);
		ListNode nheadStart = nhead;
	
		ListNode mNode = new ListNode(0);
		ListNode mNodeStart = null;
		mNodeStart = mNode;
		ListNode nNode = new ListNode(0);
		ListNode nNodeStart = null;
		nNodeStart = nNode;
		int index = 1;
		while (index <= n) {
			if (index < m) {
				ListNode node = new ListNode(head.val);
				mNode.next = node;
				mNode = mNode.next;
			}
			if (index <= n && index >= m) {
				ListNode node = new ListNode(head.val);
				nNode.next = node;
				nNode = nNode.next;
			}
			index++;
			head = head.next;
		}

		nNodeStart.next = reverse(nNodeStart.next);
		nhead.next = mNodeStart.next;
		while (nhead.next != null) {
			nhead = nhead.next;
		}
		nhead.next = nNodeStart.next;
		while (nhead.next != null) {
			nhead = nhead.next;
		}
		nhead.next = head;
		// print(nheadStart.next);
		return nheadStart.next;

	}

	public ListNode reverse(ListNode root) {
		ListNode reverse = new ListNode(0);
		ListNode temp = null;
		while (root != null) {
			temp = reverse.next;
			reverse.next = root;
			root = root.next;
			if (temp != null) {
				reverse.next.next = temp;
			} else {
				reverse.next.next = null;
			}
		}
		return reverse.next;
	}

	public void print(ListNode root) {

		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		ListNode head5 = new ListNode(6);
		ListNode head6 = new ListNode(7);
		ListNode head7 = new ListNode(8);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;
		head6.next = head7;
		ListNode ans = new Solution().reverseBetween(head, 2, 6);
		// ListNode ans = new Solution().reverse(head);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}
}
/*
 * {4,3,2,1,5}
 */
