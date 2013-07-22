package SumRoottoLeafNumbers;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	int ans = 0;

	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return 0;
		int sum = 0;
		ans = 0;

		sumNumbersHelper(root, sum);
		return ans;
	}

	public void sumNumbersHelper(TreeNode node, int sum) {
		if (node != null) {
			sum = sum * 10 + node.val;
		}

		if (node.left == null && node.right == null) {
			ans += sum;
			return;
		}

		if (node.left != null)
			sumNumbersHelper(node.left, sum);
		if (node.right != null)
			sumNumbersHelper(node.right, sum);
	}
}