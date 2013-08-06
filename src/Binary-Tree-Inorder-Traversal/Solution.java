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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
      ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root==null)
			return ans;
		inorderTraversalHelper(root, ans);
		return ans;
	}
	public void inorderTraversalHelper(TreeNode node, ArrayList<Integer> ans) {
		if(node==null)
			return;
		if(node.left!=null)
			inorderTraversalHelper(node.left,ans);
		ans.add(node.val);
		if(node.right!=null)
			inorderTraversalHelper(node.right,ans);
    }
}
