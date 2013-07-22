package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

}

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> level = new ArrayList<Integer>();

		queue.offer(root);
		queue.offer(null);
		while (queue.size() > 0) {
			TreeNode curNode = queue.poll();
			if (curNode != null) {
				level.add(curNode.val);
				if (curNode.left != null)
					queue.offer(curNode.left);
				if (curNode.right != null)
					queue.offer(curNode.right);
			} else {
				ans.add(new ArrayList<Integer>(level));
				level.clear();
				if(!queue.isEmpty()) queue.offer(null);
			}
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(1);
		System.out.println(new Solution().levelOrder(t));
	}

}
