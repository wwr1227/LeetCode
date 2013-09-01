//Time complexity:O(logk*n)
/**
class ListNode {
    int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
**/
class mergeKListsComparator implements Comparator<ListNode> {
	@Override
	public int compare(ListNode n1, ListNode n2) {
		return n1.val - n2.val;
	}
}

public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null || lists.isEmpty())
			return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), new mergeKListsComparator());
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			if (node != null)
				heap.add(lists.get(i));
		}
		ListNode headNode = null;
		ListNode curNode = null;
		while (!heap.isEmpty()) {
			if (headNode == null) {
				headNode = heap.poll();
				curNode = headNode;
			} else {
				ListNode newNode = heap.poll();
				curNode.next = newNode;
				curNode = curNode.next;
			}
			if (curNode.next != null)
				heap.add(curNode.next);
		}
		return headNode;
	}
}
