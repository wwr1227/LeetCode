
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
      // Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null || lists.size() == 0)
			return null;

		ListNode head = new ListNode(0);
		ListNode dummy = head;

		while (true) {
			int minvalue = Integer.MAX_VALUE;
			int position = -1;
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i)!= null && lists.get(i).val < minvalue) {
					minvalue = lists.get(i).val;
					position = i;
				}
			}
			if (position == -1)
				break;
			head.next = new ListNode(lists.get(position).val);
			head = head.next;
			lists.set(position, lists.get(position).next);
		}

		return dummy.next;
	}
}
