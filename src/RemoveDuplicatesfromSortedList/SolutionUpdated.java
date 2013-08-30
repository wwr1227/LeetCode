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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null)
			return head;
		ListNode cur = head;
		while(cur!=null){
			ListNode pre = cur.next;
			while(pre!=null && pre.val==cur.val)
				pre=pre.next;
			cur.next = pre;
			cur = cur.next;			
		}
        return head;
    }
}
