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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(preorder==null||inorder==null)
			return null;
		if(preorder.length!=inorder.length)
			return null;
		
		return buildTreeHandler(preorder,inorder, 0,preorder.length-1,0,inorder.length-1);
    }
	public TreeNode buildTreeHandler(int[] preorder,int[] inorder, int preLeft,int preRight, int inLeft, int inRight){
		if(preLeft>preRight)
			return null;
		if(inLeft>inRight)
			return null;
		int rootValue = preorder[preLeft];
		int pos=-1;
		for(int i=inLeft;i<=inRight;i++){
			if(rootValue==inorder[i]){
				pos=i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootValue);
		root.left=buildTreeHandler(preorder,inorder,preLeft+1,preLeft+pos-inLeft,inLeft,pos-1);
		root.right=buildTreeHandler(preorder,inorder,preLeft+pos-inLeft+1,preRight,pos+1,inRight);
		return root;
	}
}
