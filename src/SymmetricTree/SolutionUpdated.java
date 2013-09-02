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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;        
        return DFS(root.left,root.right);
    }
    public boolean DFS(TreeNode left, TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        if(left.val!=right.val)
            return false;
        return DFS(left.right, right.left)&& DFS(left.left, right.right);
    }
}
