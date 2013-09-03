//O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    	public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        	if(head==null)
			return null;
		int len=0;
        	ListNode cur = head;
		while(cur!=null){
			len++;
			cur=cur.next;
		}
		return generateBST(head,0,len-1);
    	}
	public TreeNode generateBST(ListNode head,int left,int right){
		if(left>right)
			return null;
		int mid = left+(right-left)/2;
		TreeNode leftTree = generateBST(head,left,mid-1);
		TreeNode root = new TreeNode(head.val);
		root.left=leftTree;
		if (head.next != null) { // "move to next"
			head.val = head.next.val;
			head.next = head.next.next;
		}
		TreeNode rightTree=generateBST(head,mid+1,right);
		root.right=rightTree;		
		return root;
	}
}
