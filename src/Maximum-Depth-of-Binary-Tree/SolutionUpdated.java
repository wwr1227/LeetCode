//Time complexity:O(n)
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
    	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	        if(root==null)
	            return 0;
	        int leftDepth =  maxDepth(root.left);
	        int rightDepth =  maxDepth(root.right);
	        if(leftDepth==0) return rightDepth+1;
	        if(rightDepth==0) return leftDepth+1;
	        return Math.max(leftDepth,rightDepth)+1;
    	}
}
