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
		if(root.left==null && root.right==null)
			return 1;
		int leftHeigh=maxDepth(root.left)+1;
		int rightHeigh=maxDepth(root.right)+1;
		return Math.max(leftHeigh,rightHeigh);
    	}
}
