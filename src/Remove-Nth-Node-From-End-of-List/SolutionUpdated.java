/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(n<=0)
			return head;
		ListNode virtul = new ListNode(0);
		virtul.next=head;
		ListNode fastNode = virtul;
		ListNode slowNode = virtul;
		int index=0;
		while(fastNode.next!=null){
			fastNode=fastNode.next;
			index++;
			if(index>n){
				slowNode=slowNode.next;
			}
		}
        slowNode.next =  slowNode.next.next;
		return virtul.next;	
    }
}
