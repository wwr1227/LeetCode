public class Solution {
   /**
     * 
	 dp[i][j][k] 代表了s1从i开始，s2从j开始，长度为k的两个substring是否为scramble string。
	 * 
	 * 有三种情况需要考虑：
	 * 
	 * 1. 如果两个substring相等的话，则为true
	 * 
	 * 2. 如果两个substring中间某一个点，左边的substrings为scramble string，
	 * 同时右边的substrings也为scramble string，则为true
	 * 
	 * 3. 如果两个substring中间某一个点，s1左边的substring和s2右边的substring为scramble string,
	 * 同时s1右边substring和s2左边的substring也为scramble string，则为true
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];

		for (int i = n - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--)
				for (int k = 1; k <= n - Math.max(i, j); k++) {
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k)))
						dp[i][j][k] = true;
					else {
						for (int l = 1; l < k; l++) {
							if (dp[i][j][l] && dp[i + l][j + l][k - l]
									|| dp[i][j + k - l][l]
									&& dp[i + l][j][k - l]) {
								dp[i][j][k] = true;
								break;
							}
						}
					}
				}

		return dp[0][0][n];
	}
}
