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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValidBSTHandler(root.left,min,root.val)&&isValidBSTHandler(root.right,root.val,max); 
    }
    public boolean isValidBSTHandler(TreeNode root, int min, int max){
        if (root == null) return true;
        if(root.val<=min||root.val>=max){
            return false;
        }else{
            return isValidBSTHandler(root.left,min,root.val)&&isValidBSTHandler(root.right,root.val,max); 
        }
    }
}
