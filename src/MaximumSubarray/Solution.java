package MaximumSubarray;

public class Solution {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;
		int len = A.length;
		if (len == 0)
			return 0;

		int sum = A[0];
		int max = A[0];

		for (int i = 1; i < len; i++) {
			if (sum > 0)
				sum += A[i];
			else
				sum = A[i];

			if (sum > max)
				max = sum;
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
