package UniqueBinarySearchTreesII;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; left = null; right = null; } }
 */
public class Solution {

	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function

		return getTrees(1, n);
	}

	public ArrayList<TreeNode> getTrees(int start, int end) {

		ArrayList<TreeNode> ans = new ArrayList<TreeNode>();

		if (start > end) {
			ans.add(null);
			return ans;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = getTrees(start, i - 1);
			ArrayList<TreeNode> right = getTrees(i + 1, end);

			for (int l = 0; l < left.size(); l++) {
				for (int r = 0; r < right.size(); r++) {
					TreeNode node = new TreeNode(i);
					node.left = left.get(l);
					node.right = right.get(r);
					ans.add(node);
				}
			}
		}

		return ans;
	}
}
