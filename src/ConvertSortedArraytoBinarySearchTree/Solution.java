package ConvertSortedArraytoBinarySearchTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (num == null || num.length == 0) {
			return null;
		}
		return BSTHelper(num, 0, num.length - 1);

	}

	public TreeNode BSTHelper(int[] num, int start, int end) {

		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(num[mid]);

		node.left = BSTHelper(num, start, mid - 1);
		node.right = BSTHelper(num, mid + 1, end);

		return node;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
