public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(l1==null && l2==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		int sum =0;
		int carry = 0;
		ListNode resList = new ListNode(0);
        ListNode dummy = resList;
		while(l1!=null && l2!=null){
			sum = l1.val + l2.val + carry;
			carry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			resList.next = newNode;
			resList = resList.next;
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null){
			sum = l1.val + carry;
			carry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			resList.next = newNode;
			resList = resList.next;
			l1=l1.next;
		}
		while(l2!=null){
			sum = l2.val + carry;
			carry = sum/10;
			ListNode newNode = new ListNode(sum%10);
			resList.next = newNode;
			resList = resList.next;
			l2=l2.next;
		}
		if(carry!=0){
			ListNode newNode = new ListNode(carry);
			resList.next = newNode;
		}
        return dummy.next;
    }
}
