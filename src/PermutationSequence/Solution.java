package PermutationSequence;

public class Solution {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return "";
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		// change K from (1,n) to (0, n-1) to accord to index
		k--;
		String ans = "";
		int permCount = f(n);
		while (n > 0) {
			permCount = permCount / n;
			int choosed = k / permCount;
			// System.out.println("choosed:" + choosed);
			ans += String.valueOf(nums[choosed]);
			for (int j = choosed; j < n - 1; j++) {
				nums[j] = nums[j + 1];
			}
			k = k % permCount;
			n--;
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		System.out.println(su.getPermutation(4, 17));
	}

	public int f(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		return f(n - 1) * n;

	}
}
