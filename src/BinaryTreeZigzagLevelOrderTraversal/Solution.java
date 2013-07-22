package BinaryTreeZigzagLevelOrderTraversal;

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
				if (qe.isEmpty())
					break;
				qe.add(null);
			} else {
				item.add(node.val);
				if (node.left != null) {
					qe.offer(node.left);
				}
				if (node.right != null) {
					qe.offer(node.right);
				}

			}
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		// {1,2,3,4,#,#,5}
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;
		System.out.println(new Solution().zigzagLevelOrder(t1));

	}
}
