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
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	    	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if(root==null)
			return ans;
		dfs(root,sum,ans,item);
		return ans;
	}
	public void dfs(TreeNode node, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> item){
		if(node==null)
			return;
		item.add(node.val);
		if(node.left==null&&node.right==null){
			if(sum==node.val)
				ans.add(new ArrayList<Integer>(item));
			item.remove(item.size()-1);			
			return;
		}
		dfs(node.left,sum-node.val,ans,item);
		dfs(node.right,sum-node.val,ans,item);
		item.remove(item.size()-1);
	}
}
