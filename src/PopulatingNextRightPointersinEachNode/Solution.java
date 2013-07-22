package PopulatingNextRightPointersinEachNode;
public class Solution {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (root == null || root.left == null || root.right == null) {
			return;
		}

		root.left.next = root.right;
		if (root.next != null) {
			root.right.next = root.next.left;
		} else {
			root.right.next = null;
		}

		connect(root.left);
		connect(root.right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}