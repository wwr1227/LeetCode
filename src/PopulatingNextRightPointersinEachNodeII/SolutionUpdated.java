/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (root == null)
			return;
		TreeLinkNode cur =root.next;
		while(cur!=null){
			if(cur.left!=null){
				cur = cur.left;
				break;
			}
			if(cur.right!=null){
				cur = cur.right;
				break;
			}
			cur=cur.next;
		}
		if(root.right!=null)
			root.right.next = cur;
		if (root.left != null) {
			if(root.right!=null){
				root.left.next = root.right;
			} else {
				root.left.next = cur;
			}
		}
		connect(root.right);
		connect(root.left);	
	}
}
