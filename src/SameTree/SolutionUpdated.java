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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(p==null && q==null)
			return true;
		if(p==null || q==null)
			return false;
		
		if(p.val!=q.val)
			return false;
		else{
			return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		}
        
    }
}
