package ConstructBinaryTreefromPreorderandInorderTraversal;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (preorder == null || inorder == null)
			return null;

		if (preorder.length == 0 || inorder.length == 0)
			return null;
		if (preorder.length != inorder.length)
			return null;

		return getTree(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);

	}

	public TreeNode getTree(int[] preorder, int[] inorder, int preleft,
			int preright, int inleft, int inright) {

		if (inleft > inright)
			return null;
		if (preleft > preright)
			return null;
		int rootVal = preorder[preleft];
		int pos = inleft;
		for (pos = inleft; pos <= inright; pos++) {
			if (inorder[pos] == rootVal)
				break;
		}

		TreeNode node = new TreeNode(rootVal);
		node.left = getTree(preorder, inorder, preleft + 1, preleft + pos
				- inleft, inleft, pos - 1);
		node.right = getTree(preorder, inorder, preleft + pos - inleft + 1,
				preright, pos + 1, inright);
		return node;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int preorder[] = { 1, 2 };
		int inorder[] = { 2, 1 };
		System.out.println(su.buildTree(preorder, inorder));
	}

}
