//O(n)
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
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	flattenAndReturn(root);
    }

    private TreeNode flattenAndReturn(TreeNode root){
        if (root == null)
            return null;

        TreeNode leftTail = flattenAndReturn(root.left);
        if(leftTail == null)       
            leftTail = root;
        
        TreeNode rightTail = flattenAndReturn(root.right);
        if(rightTail == null)        
            rightTail = leftTail;
        
        TreeNode temp = root.right;
        root.right = root.left;
        leftTail.right = temp;
        root.left = null;
        return rightTail;
    }
}
