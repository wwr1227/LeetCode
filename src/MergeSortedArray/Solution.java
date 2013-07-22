package MergeSortedArray;

public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int mergeLen = m + n - 1;
		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[mergeLen--] = A[m - 1];
				m--;
			} else {
				A[mergeLen--] = B[n - 1];
				n--;
			}
		}
		for (int i = 0; i < n; i++) {
			A[i] = B[i];
		}
	}
}
