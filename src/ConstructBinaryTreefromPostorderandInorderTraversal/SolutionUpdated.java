//Time complexity:O(n^2)
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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(postorder==null||inorder==null)
			return null;
		if(postorder.length!=inorder.length)
			return null;
		
		return buildTreeHandler(postorder,inorder, 0,postorder.length-1,0,inorder.length-1);
    }
	public TreeNode buildTreeHandler(int[] postorder,int[] inorder, int postLeft,int postRight, int inLeft, int inRight){
		if(postLeft>postRight)
			return null;
		if(inLeft>inRight)
			return null;
		int rootValue = postorder[postRight];
		int pos=inLeft;
		for(int i=inLeft;i<=inRight;i++){
			if(rootValue==inorder[i]){
				pos=i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootValue);
		root.left=buildTreeHandler(postorder,inorder,postLeft,postLeft+pos-inLeft-1,inLeft,pos-1);
		root.right=buildTreeHandler(postorder,inorder,postLeft+pos-inLeft,postRight-1,pos+1,inRight);
		return root;
	}
}
