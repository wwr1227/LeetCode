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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        return sumNumbersHandler(root,0);
    }
    public int sumNumbersHandler(TreeNode root, int ans){
        if(root == null)
            return 0;
            
        if(root.left==null&&root.right==null){
           return ans*10 + root.val;
        }
        
        ans = ans*10 + root.val;
        
        return sumNumbersHandler(root.left, ans)+sumNumbersHandler(root.right,ans);
    }
}
