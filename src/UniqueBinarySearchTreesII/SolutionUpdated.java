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
	public ArrayList<TreeNode> generateTreesHandler(int start, int end){
		ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
		if(start>end){
			trees.add(null);
			return trees;
		}
		for(int mid = start; mid<=end; mid++){
			ArrayList<TreeNode>  left = generateTreesHandler(start, mid-1);
			ArrayList<TreeNode>  right = generateTreesHandler(mid+1, end);
			for(int i = 0;i<left.size();i++){
				for(int j = 0;j<right.size();j++){
					TreeNode root = new TreeNode(mid);
					root.left = left.get(i);
					root.right = right.get(j);
					trees.add(root);
				}
			}
		}
		return trees;	
	}
}
