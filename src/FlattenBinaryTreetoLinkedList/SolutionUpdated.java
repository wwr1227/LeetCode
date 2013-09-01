//Time complexity:O(n)
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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
    		return;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);
	TreeNode flattenNode = null;
	while(!stack.isEmpty()){
		TreeNode node = stack.pop();
		if(node.right!=null){
			stack.push(node.right);
			node.right=null;
		}
		if(node.left!=null){
			stack.push(node.left);
			node.left=null;
		}
		if(flattenNode==null){
			flattenNode=node;
		}else{
			flattenNode.left=null;
			flattenNode.right=node;
			flattenNode=flattenNode.right;
		}
	}
    }
}
