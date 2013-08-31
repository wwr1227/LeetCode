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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null)
    		return head;
	ListNode smallerHead = new ListNode(0);
	ListNode smaller = smallerHead;
	ListNode greaterHead = new ListNode(0);
	ListNode greater = greaterHead;
	ListNode cur = head;		
	while(cur!=null){
		if(cur.val<x){
			smaller.next = cur;
			smaller = smaller.next;
		}else{
			greater.next =cur;
			greater = greater.next;
		}
		cur =cur.next;
	}
        greater.next=null;
	smaller.next=greaterHead.next;
	return smallerHead.next;
    }
}
