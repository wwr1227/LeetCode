public class removeNthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode fastListNode = head, slowListNode = head;

		for (int i = 0; i < n; i++) {
			fastListNode = fastListNode.next;
		}
		if (fastListNode == null)
			return head.next;
		while (fastListNode.next != null) {
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next;
		}
		slowListNode.next = slowListNode.next.next;
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
