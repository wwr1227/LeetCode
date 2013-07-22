package ConstructBinaryTreefromPostorderandInorderTraversal.copy;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (postorder == null || inorder == null)
			return null;

		if (postorder.length == 0 || inorder.length == 0)
			return null;
		if (postorder.length != inorder.length)
			return null;

		return getTree(postorder, inorder, 0, postorder.length - 1, 0,
				inorder.length - 1);

	}

	public TreeNode getTree(int[] postorder, int[] inorder, int preleft,
			int preright, int inleft, int inright) {

		if (inleft > inright)
			return null;
		if (preleft > preright)
			return null;
		int rootVal = postorder[preright];
		int pos = inleft;
		for (pos = inleft; pos <= inright; pos++) {
			if (inorder[pos] == rootVal)
				break;
		}

		TreeNode node = new TreeNode(rootVal);
		node.left = getTree(postorder, inorder, preleft, preleft + pos - inleft
				- 1, inleft, pos - 1);
		node.right = getTree(postorder, inorder, preleft + pos - inleft,
				preright - 1, pos + 1, inright);
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
