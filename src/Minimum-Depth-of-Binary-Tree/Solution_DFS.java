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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
	if (root == null)  return 0;
	int left = minDepthDFS1(root.left);
	int right = minDepthDFS1(root.right);
	if (right == 0)  return left+1;
	if (left == 0)  return right+1;
	return Math.min(left, right)+1;
    }
}
