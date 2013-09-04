//O(m*n)
public class Solution {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (S == null || S.length() == 0)
			return 0;

		int[][] ans = new int[T.length() + 1][S.length() + 1];
		Arrays.fill(ans[0],1);
		for (int j = 1; j <= T.length(); j++) {
			for (int i = 1; i <= S.length(); i++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					ans[j][i] += (ans[j][i - 1] + ans[j - 1][i - 1]);
				} else {
					ans[j][i] += ans[j][i - 1];
				}
			}
		}
		return ans[T.length()][S.length()];
	}
}
