package ConvertSortedListtoBinarySearchTree;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode copy = head;
		while (copy.next != null) {
			copy = copy.next;
			len++;
		}
		return BSTHelper(head, 0, len);

	}

	public TreeNode BSTHelper(ListNode head, int start, int end) {

		if (start > end)
			return null;
		int mid = (start + end) / 2;

		ListNode copy = head;
		int i = start;
		while (i < mid && copy.next != null) {
			copy = copy.next;
			i++;
		}
		TreeNode node = new TreeNode(copy.val);

		node.left = BSTHelper(head, start, mid - 1);
		node.right = BSTHelper(copy.next, mid + 1, end);

		return node;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
