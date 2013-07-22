package SearchinRotatedSortedArray;

public class Solution {
	private int pivot = -1;

	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null)
			return 0;
		int len = A.length;
		if (len == 0)
			return 0;

		if (len == 1) {
			int rIndex = searchHelper(A, target, 0, len - 1);
			if (rIndex != -1)
				return rIndex;
		} else {
			getRotate(A, 0, len - 2);
			if (pivot == -1) {
				if (A[len - 1] < A[len - 2])
					pivot = len - 2;
				else
					pivot = len - 1;
			}
			int rIndex = -1;
			int lIndex = -1;
			if (pivot == len - 1)
				rIndex = searchHelper(A, target, 0, len - 1);
			else {
				rIndex = searchHelper(A, target, 0, pivot);
				lIndex = searchHelper(A, target, pivot + 1, len - 1);
			}
			if (rIndex != -1)
				return rIndex;
			else if (lIndex != -1)
				return lIndex;
		}
		return -1;
	}

	public void getRotate(int[] A, int left, int right) {
		if (left > right)
			return;
		int mid = (left + right) / 2;
		if (A[mid] > A[mid + 1]) {
			pivot = mid;
		} else {
			getRotate(A, mid + 1, right);
			getRotate(A, left, mid - 1);
		}
	}

	public int searchHelper(int[] A, int target, int left, int right) {

		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (A[mid] == target)
			return mid;
		else if (A[mid] < target) {
			return searchHelper(A, target, mid + 1, right);
		} else {
			return searchHelper(A, target, left, mid - 1);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] A = { 3, 5, 1 };
		int target = 1;
		System.out.println(su.search(A, target));
	}

}
