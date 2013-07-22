package RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// !!!!
// http://fisherlei.blogspot.com/2012/12/leetcode-recover-binary-search-tree.html
// !!!
public class Solution {
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		List<TreeNode> list = new ArrayList<TreeNode>();
		List<Integer> value = new ArrayList<Integer>();

		inorder(root, list, value);

		Collections.sort(value);
		for (int i = 0; i < value.size(); i++) {
			list.get(i).val = value.get(i);
		}

	}

	public void inorder(TreeNode root, List<TreeNode> list, List<Integer> value) {

		if (root == null) {
			return;
		}

		inorder(root.left, list, value);
		value.add(root.val);
		list.add(root);
		inorder(root.right, list, value);

	}
}
