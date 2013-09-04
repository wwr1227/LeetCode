//O(n)
//You may not modify the values in the list, only nodes itself can be changed.!!!
//I forgot!
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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
      
	if (head==null)
		return head;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	while(head!=null && head.next!=null){
		int temp = head.val;
		head.val = head.next.val;
		head.next.val = temp;
		head = head.next.next;
	}
        return dummy.next;
    }
}
