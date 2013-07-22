package RemoveDuplicatesfromSortedArrayII;

public class Solution {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;

		int len = A.length;
		if (A.length == 0)
			return len;
		int[] B = A;
		int ans = B.length;
		int flag = B[0] - 1;
		boolean dup = false;
		for (int i = 1; i < len; i++) {
			if (B[i] == B[i - 1] && !dup) {
				dup = true;
			} else if (B[i] == B[i - 1] && dup) {
				ans--;
				B[i - 1] = flag;
			} else if (B[i] != B[i - 1]) {
				dup = false;
			}
		}
		// print(B, len);
		for (int i = 0; i < len; i++) {
			if (B[i] == flag) {
				B = remove(B, i);
				i--;
			}
		}
		for (int i = 0; i < ans; i++) {
			A[i] = B[i];
		}
		// print(A, ans);
		return ans;
	}

	public int[] remove(int[] A, int deleteIndex) {
		for (int i = deleteIndex; i < A.length - 1; i++) {
			A[i] = A[i + 1];
		}
		// System.out.println();
		return A;
	}

	public void print(int[] A, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1, 1 };
		System.out.println(new Solution().removeDuplicates(A));
	}
}
