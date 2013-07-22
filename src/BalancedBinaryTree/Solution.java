package BalancedBinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

}

public class Solution {
	public int getDepth(TreeNode pbs) {
		if (pbs == null)
			return 0;
		else {
			int ld = getDepth(pbs.left);
			int rd = getDepth(pbs.right);
			return 1 + (ld > rd ? ld : rd);
		}
	}

	public boolean isBalanced(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (root == null)
			return true;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);

		int diff = leftDepth - rightDepth;
		if (diff < -1 || diff > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
