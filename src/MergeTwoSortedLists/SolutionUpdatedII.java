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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1==null && l2==null)
            return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode newNode = new ListNode(0);
        ListNode dummy=newNode;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ListNode node = new ListNode(l1.val);
                newNode.next=node;
                newNode=newNode.next;
                l1=l1.next;
            }else{
                ListNode node = new ListNode(l2.val);
                newNode.next=node;
                newNode=newNode.next;
                l2=l2.next;
            }
        }
        if(l1!=null){
            newNode.next=l1;
        }
        
        if(l2!=null){;
            newNode.next=l2;
        }
        return dummy.next;
    }
}
