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
//=========================================================================================================
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (root == null)
			return ans;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				ans.add(new ArrayList<Integer>(item));
				item.clear();
				leftToRight = !leftToRight;
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			} else {
				if (leftToRight)
					item.add(cur.val);
				else
					item.add(0, cur.val);
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
		}
		return ans;
	}
}
//======================================================================================================
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
	private void swap(Stack<TreeNode> s1, Stack<TreeNode> s2) {
	    // TODO Auto-generated method stub
		Stack<TreeNode> holdStack = new Stack<TreeNode>();
		while(!s2.isEmpty())
		    holdStack.push(s2.pop());
		while(!holdStack.isEmpty())
		    s1.push(holdStack.pop());        
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if(root==null) return ans;
		Stack<TreeNode> currentLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		boolean leftToRight = true;
		currentLevel.push(root);
		while (!currentLevel.isEmpty()) {
    		while (!currentLevel.isEmpty()) {
    			TreeNode currNode = currentLevel.pop();
    			if (currNode != null) {
    				item.add(currNode.val);
    				if (leftToRight) {
    					nextLevel.push(currNode.left);
    					nextLevel.push(currNode.right);
    				} else {
    					nextLevel.push(currNode.right);
    					nextLevel.push(currNode.left);
    				}
    			}
            	}
            	if(item.isEmpty())break;
		    ans.add(new ArrayList<Integer>(item));
        	item.clear();
		leftToRight = !leftToRight;
		swap(currentLevel, nextLevel);			
		}
		return ans;
	}
}
