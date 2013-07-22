package SearchforaRange;

public class Solution {
	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int[] ans = { -1, -1 };

		if (A == null)
			return ans;
		int len = A.length;
		if (len == 0)
			return ans;

		searchRangeHelper(A, target, 0, len - 1, ans);

		return ans;
	}

	public void searchRangeHelper(int[] A, int target, int left, int right,
			int[] ans) {

		if (left > right)
			return;

		int mid = (left + right) / 2;

		if (target == A[mid]) {
			ans = insertAns(ans, mid);
			searchRangeHelper(A, target, mid + 1, right, ans);
			searchRangeHelper(A, target, left, mid - 1, ans);
		} else if (target > A[mid]) {
			searchRangeHelper(A, target, mid + 1, right, ans);
		} else {
			searchRangeHelper(A, target, left, mid - 1, ans);
		}

	}

	public int[] insertAns(int[] A, int value) {

		if (A[0] == -1)
			A[0] = value;
		if (A[1] == -1)
			A[1] = value;
		if (value > A[1])
			A[1] = value;
		if (value < A[0])
			A[0] = value;

		return A;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] A = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] ans = su.searchRange(A, target);

		System.out.println(ans[0] + " " + ans[1]);
	}

}
