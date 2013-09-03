//O(Catalan(n))
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return generateTreesHandler(1, n);
    	}
	public ArrayList<TreeNode> generateTreesHandler(int start, int end) {
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if (start > end) {
			trees.add(null);
			return trees;
		}
		for (int i = start; i <= end; i++) {
			for (TreeNode left : generateTreesHandler(start, i - 1)) {
				for (TreeNode right : generateTreesHandler(i + 1, end)) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					trees.add(root);
				}
			}
		}
		return trees;
	}
}
