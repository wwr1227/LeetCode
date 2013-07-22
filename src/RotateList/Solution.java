package RotateList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;
		ListNode ans = new ListNode(0);
		ListNode pNode = head;
		int length = 0;
		while (pNode != null) {
			length++;
			pNode = pNode.next;
		}
		n %= length;
		pNode = head;
		int index = 0;
		while (pNode != null && pNode.next != null) {

			index++;
			if (index == length - n) {
				ans.next = pNode.next;
				pNode.next = null;

			}
			pNode = pNode.next;
		}
		pNode = ans;
		while (pNode.next != null) {
			pNode = pNode.next;
		}
		pNode.next = head;

		return ans;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		head.next = head1;
		int n = 1;
		System.out.println(new Solution().rotateRight(head, n));
	}
	/**
	 * {1,2,3}, 1 {2,3,1} {3,1,2}
	 */
}
