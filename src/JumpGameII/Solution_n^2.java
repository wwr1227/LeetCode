//O(n^2)
public class Solution {
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null)
			return 0;
		int len = A.length;

		if (len == 0)
			return 0;
		int[] distance = new int[len];
		for (int i = 0; i < len; i++) {
			distance[i] = i + A[i];
		}
		int[] ans = new int[len];
		ans[0] = 0;
		for (int i = 1; i < len; i++) {
			int j;
			for (j = 0; j <= i; j++) {
				if (distance[j] >= i) {
					break;
				}
			}
			ans[i] = ans[j] + 1;
		}
		return ans[len - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 1, 1, 4 };
		Solution su = new Solution();
		System.out.println(su.jump(A));
	}

}
