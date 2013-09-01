//Time complexity:O(n)
/**
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

}
**/
public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;
		ArrayList<Integer> item = new ArrayList<Integer>();
		Queue<TreeNode> qe = new LinkedList<TreeNode>();
		qe.add(root);
		qe.add(null);
		boolean leftToRight = true;
		while (!qe.isEmpty()) {
			TreeNode node = qe.poll();
			if (node == null) {
				if (leftToRight) {
					ans.add(new ArrayList<Integer>(item));
				} else {
					ArrayList<Integer> reverseitem = new ArrayList<Integer>();
					for (int i = item.size() - 1; i >= 0; i--) {
						reverseitem.add(item.get(i));
					}
					ans.add(new ArrayList<Integer>(reverseitem));
				}
				item.clear();
				leftToRight = !leftToRight;
				if (qe.isEmpty()) break;
				qe.add(null);
			} else {
				item.add(node.val);
				if (node.left != null) 
					qe.offer(node.left);
				if (node.right != null) 
					qe.offer(node.right);
			}
		}
		return ans;
	}
}
