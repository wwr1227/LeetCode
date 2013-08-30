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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if(root == null)
		return;
	
	TreeNode parent = null;
        TreeNode current = root;
	TreeNode prev = null;
        TreeNode mistake_node1 = null;
        TreeNode mistake_node2 = null;
		
	while(current!=null){
		if (current.left==null) {
			if(parent!=null && parent.val > current.val){
				if(mistake_node1==null)
					mistake_node1=parent;
				mistake_node2 = current;
			}				
			parent = current;
			current = current.right;
		}else{
			//http://en.wikipedia.org/wiki/Threaded_binary_tree
			prev = current.left;
		        while (prev.right!=null && prev.right != current)
		            prev = prev.right;
		        if (prev.right == null) {
		            prev.right = current;
		            current = current.left;
		        } else {
		            if (parent.val > current.val) {
		                if (mistake_node1 == null) 
		                    mistake_node1 = parent;
		                mistake_node2 = current;
		            }
		            prev.right = null;
		            parent = current;
		            current = current.right;
		        }
		}
        }
        if (mistake_node1!=null && mistake_node2!=null){
		int temp =mistake_node1.val;
		mistake_node1.val = mistake_node2.val;
		mistake_node2.val = temp;
	}
    }
}
