package findMedianSortedArrays;

public class Solution {

	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int aSize = A.length;
		int bSize = B.length;
		System.out.println("aSize:" + aSize + ";bSize:" + bSize);

		if (aSize > bSize) {
			int[] temp = A;
			A = B;
			B = temp;
		}
		aSize = A.length;
		bSize = B.length;
		if (aSize == 1) {
			System.out.println(A[0] + " " + B[bSize / 2]);
			if (bSize % 2 == 0) {
				if (A[0] >= B[bSize / 2]) {
					System.out.println("!@");
					return B[bSize / 2];
				} else if (A[0] <= B[bSize / 2]) {
					System.out.println("@@@");
					return B[bSize / 2 - 1];
				}
			} else
				return B[bSize / 2];
		}
		if (A[aSize / 2] == B[bSize / 2]) {
			System.out.println(A[aSize / 2] + "=" + B[bSize / 2]);
			return A[aSize / 2];
		} else if (A[aSize / 2] > B[bSize / 2]) {
			System.out.println(A[aSize / 2] + ">" + B[bSize / 2]);
			int[] AA = subArray(A, 0, aSize / 2);
			int[] BB = subArray(B, aSize / 2, bSize - 1);
			return findMedianSortedArrays(AA, BB);
		} else {
			System.out.println(A[aSize / 2] + "<" + B[bSize / 2]);
			int[] AA = subArray(A, aSize / 2, aSize - 1);
			int[] BB = subArray(B, 0, bSize - 1 - aSize / 2);
			return findMedianSortedArrays(AA, BB);
		}
	}

	public int[] subArray(int[] orgin, int start, int end) {
		int[] ans = new int[end - start + 1];
		int j = 0;
		System.out.print("subArray:");
		for (int i = start; i <= end; i++) {
			ans[j] = orgin[i];
			System.out.print(ans[j] + " ");
			j++;
		}
		System.out.println();
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] A = { 1, 2, 8, 9, 10 };
		int[] B = { 1, 2, 3, 4, 11 };
		System.out.println(su.findMedianSortedArrays(A, B));
	}
}
