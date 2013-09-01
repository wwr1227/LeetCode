//Time complexity:O(log(m+n))
public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = A.length;
		int n = B.length;
		if ((m + n) % 2 == 1)
			return (double) findKth(A, 0, m, B, 0, n, (m + n + 1) / 2);
		else {
			return (findKth(A, 0, m, B, 0, n, (m + n) / 2) + findKth(A, 0, m,
					B, 0, n, (m + n) / 2 + 1)) / 2.0;
		}
	}

	int findKth(int A[], int Astart, int m, int B[], int Bstart, int n, int k) {

		if (m <= 0)
			return B[Bstart + k - 1];
		if (n <= 0)
			return A[Astart + k - 1];
		if (k <= 1)
			return Math.min(A[Astart], B[Bstart]);

		int ans = 0;
		if (m / 2 + n / 2 + 1 >= k) {
			if (A[Astart + m / 2] >= B[Bstart + n / 2])
				ans = findKth(A, Astart, m / 2, B, Bstart, n, k);
			else
				ans = findKth(A, Astart, m, B, Bstart, n / 2, k);
		} else {
			if (A[Astart + m / 2] >= B[Bstart + n / 2])
				ans = findKth(A, Astart, m, B, Bstart + n / 2 + 1, n - n / 2
						- 1, k - n / 2 - 1);
			else
				ans = findKth(A, Astart + m / 2 + 1, m - m / 2 - 1, B, Bstart,
						n, k - m / 2 - 1);
		}
		return ans;
	}
}
