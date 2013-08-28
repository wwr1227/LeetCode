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
		TreeNode root = new TreeNode(0);
		dfs(root, head);
		return root;        
    }
	public void dfs(TreeNode root, ListNode head){
		if(head.next==null){
			root.val=head.val;
			root.left=null;
			root.right=null;
			return;
		}
		ListNode pre=head;
		ListNode slow=head.next;
		ListNode fast=head.next.next;
		while(fast!=null&&fast.next!=null){
			pre=pre.next;
			slow=slow.next;
			fast=fast.next.next;
		}
		
		root.val = slow.val;
		pre.next=null;
		
		root.left =new TreeNode(0);
		dfs(root.left,head);
		if(slow.next!=null){
			root.right =new TreeNode(0);
			dfs(root.right, slow.next);
		}
	}
}
