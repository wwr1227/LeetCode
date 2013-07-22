package BinaryTreeLevelOrderTraversalII;

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
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ans;

		ArrayList<Integer> item = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				item.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			} else {
				ans.add(new ArrayList<Integer>(item));
				item.clear();
				if (queue.isEmpty())
					break;
				queue.add(null);
			}
		}
		ans = reverse(ans);

		return ans;
	}

	public ArrayList reverse(ArrayList a) {
		ArrayList b = new ArrayList();

		for (int i = a.size() - 1; i >= 0; i--) {
			b.add(a.get(i));
		}
		return b;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		// TreeNode t3 = new TreeNode(3);
		// TreeNode t4 = new TreeNode(4);
		// TreeNode t5 = new TreeNode(5);
		// {1,2,3,4,#,#,5}
		t1.left = t2;
		// t1.right = t3;
		// t2.left = t4;
		// t3.right = t5;
		System.out.println(new Solution().zigzagLevelOrder(t1));

	}
}
