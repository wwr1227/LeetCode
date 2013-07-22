package SearchinRotatedSortedArrayII;

public class Solution {
	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = A.length;
		int start = 0;
		int end = len - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target)
				return true;
			if (A[start] < A[mid]) {
				if (target < A[mid] && target >= A[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (A[start] > A[mid]) {
				if (target > A[mid] && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				start++;
			}
		}
		return false;
	}
}
