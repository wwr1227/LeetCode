package MergekSortedLists;

import java.util.ArrayList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null)
			return null;
		int size = lists.size();
		if (size == 0)
			return null;
		if (size == 1)
			return lists.get(0);

		int curSize = size;
		while (curSize > 1) {
			int halfSize = (curSize + 1) / 2;
			for (int i = 0; i < halfSize && i + halfSize < curSize; ++i) {
				ListNode first = lists.get(i);
				ListNode second = lists.get(i + halfSize);
				ListNode result = mergeTwoLists(first, second);

				lists.set(i, result);
			}
			curSize = halfSize;
		}
		return lists.get(0);
	}

	public ListNode mergeTwoLists(ListNode first, ListNode second) {

		ListNode res = new ListNode(-1);
		ListNode mergeList = res;
		while (first != null && second != null) {
			if (first.val < second.val) {
				res.next = first;
				first = first.next;
			} else {
				res.next = second;
				second = second.next;
			}
			res = res.next;
		}
		if (first != null)
			res.next = first;
		if (second != null)
			res.next = second;
		// print(mergeList);
		return mergeList.next;

	}

	public void print(ListNode root) {
		while (root.next != null) {
			System.out.print(root.val + " -> ");
			root = root.next;
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// {1,2,2},{1,1,2}]
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(2);
		ListNode l13 = new ListNode(2);
		l11.next = l12;
		l12.next = l13;
		ListNode l21 = new ListNode(1);
		ListNode l22 = new ListNode(1);
		ListNode l23 = new ListNode(2);
		l21.next = l22;
		l22.next = l23;
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l11);
		lists.add(l21);
		System.out.println(new Solution().mergeKLists(lists));
	}

}
