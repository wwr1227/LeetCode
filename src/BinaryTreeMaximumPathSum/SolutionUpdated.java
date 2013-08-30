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

    int ans = 0;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        	ans = 0;
		if(root==null)
			return ans;
		ans = root.val;
		maxPathSumHandler(root,Integer.MIN_VALUE);
		return ans;       
    }
	
    public int maxPathSumHandler(TreeNode root,int curSum) {
		if(root==null)
			return 0;
		int leftSum = maxPathSumHandler(root.left,curSum);
		int rightSum = maxPathSumHandler(root.right,curSum);
		int curMax = Math.max(root.val, Math.max(leftSum+root.val,rightSum+root.val));
		ans = Math.max(ans,Math.max(curMax, root.val+leftSum+rightSum));
        	return curMax;
	}
}
