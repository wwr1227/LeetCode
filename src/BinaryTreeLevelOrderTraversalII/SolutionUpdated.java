/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> layer = new ArrayList<Integer>();
		if (root == null)
			return ans;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				ans.add(0, new ArrayList<Integer>(layer));
				layer.clear();
				if (!queue.isEmpty())
					queue.offer(null);
			} else {
				layer.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
		}
		return ans;
	}
}
