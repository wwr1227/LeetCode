package SearchInsertPosition;

public class Solution {
	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;
		int len = A.length;
		if (len == 0)
			return 0;

		return searchInsertHelper(A, target, 0, len - 1);

	}

	public int searchInsertHelper(int[] A, int target, int left, int right) {
		if (left > right)
			return left;

		int mid = (left + right) / 2;

		if (target == A[mid]) {
			return mid;
		} else if (target > A[mid]) {
			return searchInsertHelper(A, target, mid + 1, right);
		} else {
			return searchInsertHelper(A, target, left, mid - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
