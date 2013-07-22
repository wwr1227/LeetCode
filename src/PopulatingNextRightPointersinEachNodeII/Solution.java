package PopulatingNextRightPointersinEachNodeII;

public class Solution {
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function

		while (root != null) {
			TreeLinkNode next = null; // the first node of next level
			TreeLinkNode prev = null; // previous node on the same level
			for (; root != null; root = root.next) {
				if (next == null)
					next = (root.left != null) ? root.left : root.right;

				if (root.left != null) {
					if (prev != null)
						prev.next = root.left;
					prev = root.left;
				}
				if (root.right != null) {
					if (prev != null)
						prev.next = root.right;
					prev = root.right;
				}
			}
			root = next; // turn to next level
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
/**
 * {} {} {}
 * 
 * {0} {0,#} {0,#}
 * 
 * {1,2} {1,#,2,#} {1,#,2,#}
 * 
 * {1,#,2} {1,#,2,#} {1,#,2,#}
 * 
 * {1,2,3} {1,#,2,3,#} {1,#,2,3,#}
 * 
 * {1,2,3,4,5} {1,#,2,3,#,4,5,#} {1,#,2,3,#,4,5,#}
 * 
 * {1,2,3,4,#,#,5} {1,#,2,3,#,4,5,#} {1,#,2,3,#,4,5,#}
 * 
 * {3,9,20,#,#,15,7} {3,#,9,20,#,15,7,#} {3,#,9,20,#,15,7,#}
 * 
 * {1,2,#,3,#,4,#,5} {1,#,2,#,3,#,4,#,5,#} {1,#,2,#,3,#,4,#,5,#}
 * 
 * {2,#,3,#,4,#,5,#,6} {2,#,3,#,4,#,5,#,6,#} {2,#,3,#,4,#,5,#,6,#}
 * 
 * {0,0,0,0,#,#,0,#,#,#,0} {0,#,0,0,#,0,0,#,0,#} {0,#,0,0,#,0,0,#,0,#}
 * 
 * {0,2,4,1,#,3,-1,5,1,#,6,#,8} {0,#,2,4,#,1,3,-1,#,5,1,#}
 * {0,#,2,4,#,1,3,-1,#,5,1,6,8,#}
 * 
 * {1,2,2,3,#,#,3,4,#,#,4} {1,#,2,2,#,3,3,#,4,4,#} {1,#,2,2,#,3,3,#,4,4,#}
 * 
 * {1,2,2,3,3,#,#,4,4} {1,#,2,2,#,3,3,#,4,4,#} {1,#,2,2,#,3,3,#,4,4,#}
 * 
 * {1,2,2,3,3,3,3,4,4,4,4,4,4,#,#,5,5} {1,#,2,2,#,3,3,3,3,#,4,4,4,4,4,4,#,5,5,#}
 * {1,#,2,2,#,3,3,3,3,#,4,4,4,4,4,4,#,5,5,#}
 * 
 * {1,2,3,4,5,#,6,7} {1,#,2,3,#,4,5,#,7,#} {1,#,2,3,#,4,5,6,#,7,#}
 * 
 * {1,2,3,4,5,#,6,7,#,#,#,#,8} {1,#,2,3,#,4,5,#,7,#} {1,#,2,3,#,4,5,6,#,7,8,#}
 * 
 * {2,1,3,0,7,9,1,2,#,1,0,#,#,8,8,#,#,#,#,7} {2,#,1,3,#,0,7,9,1,#,2,1,0,#,7,#}
 * {2,#,1,3,#,0,7,9,1,#,2,1,0,8,8,#,7,#}
 * 
 * {7,-10,2,-4,3,-8,#,#,#,#,-1,11} {7,#,-10,2,#,-4,3,-8,#,-1,#}
 * {7,#,-10,2,#,-4,3,-8,#,-1,11,#}
 */
