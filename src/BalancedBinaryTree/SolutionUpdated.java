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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root==null)
			return true;
		return !(isBalancedHandler(root)==-1);
    }
	public int isBalancedHandler(TreeNode root){
		if(root==null){
			return 0;
		}
		int heightLeft= isBalancedHandler(root.left);
        if(heightLeft==-1)
            return -1;
		int heightRight= isBalancedHandler(root.right);
        if(heightRight==-1)
            return -1;
		if(Math.abs(heightLeft - heightRight) <= 1) {		
            return 1 + Math.max(heightRight, heightLeft);
		}else{
			return -1;
		}	
	}
}
