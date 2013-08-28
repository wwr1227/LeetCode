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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(num==null||num.length==0)
			return null;		
		
        return dfs(num,0,num.length-1);
    }
	public TreeNode dfs(int[] num,int left, int right){
		if(left>right)
			return null;		
		int mid = left+(right-left)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left=dfs(num,left,mid-1);
		root.right=dfs(num,mid+1,right);
		return root;
	}
}
