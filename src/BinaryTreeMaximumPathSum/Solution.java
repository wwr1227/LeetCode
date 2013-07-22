package BinaryTreeMaximumPathSum;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	int sumMax = 0;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		int curMax = Integer.MIN_VALUE;
		sumMax = root.val;
		maxPathSumhHelper(root, curMax);
		return sumMax;
	}

	public int maxPathSumhHelper(TreeNode node, int curMax) {
		if (node == null) {
			return 0;
		}

		int leftSum = 0, rightSum = 0;
		leftSum = maxPathSumhHelper(node.left, curMax);
		rightSum = maxPathSumhHelper(node.right, curMax);

		int curSum = Math.max(node.val,
				Math.max(node.val + leftSum, node.val + rightSum));
		sumMax = Math.max(sumMax,
				Math.max(curSum, node.val + leftSum + rightSum));
		return curSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
