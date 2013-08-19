public class Solution {
    public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (n == 0 || k == 0)
			return "";
		int[] factorial = new int[n + 1];
        factorial[0]=1;
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			str.append(i);
			factorial[i] = factorial[i - 1] * i;
		}
		String perm = "";
		--k;
		for (int i = n - 1; i >= 0; --i) {
			int quotient = k / factorial[i];
			perm += str.charAt(quotient);
			str.deleteCharAt(quotient);
			k %= factorial[i];
		}
		return perm;
	}
}
