package DistinctSubsequences;

public class Solution {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (S == null || S.length() == 0)
			return 0;

		int[][] ans = new int[T.length() + 1][S.length() + 1];

		for (int j = 0; j <= T.length(); j++) {
			for (int i = 0; i <= S.length(); i++) {
				ans[j][i] = 0;
			}
		}
		for (int i = 0; i <= S.length(); i++) {
			ans[0][i] = 1;
		}
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * 此题需要使用大数运算。使用一点 DP 即可。关键是如何得到递推关系，可以这样想，设母串的长度为 j， 子串的长度为 i，我们要求的就是长度为 i
 * 的字串在长度为 j 的母串中出现的次数，设为 t[i][j]，若母串的最后一个字符与子串的最后一个字符不同，则长度为 i 的子串在长度为 j
 * 的母串中出现的次数就是母串的前 j - 1 个字符中子串出现的次数，即 t[i][j] = t[i][j
 * -1]，若母串的最后一个字符与子串的最后一个字符相同，那么除了前 j - 1 个字符出现字串的次数外，还要加上子串的前 i - 1 个字符在母串的前 j
 * - 1 个字符中出现的次数，即 t[i][j] = t[i][j - 1] + t[i - 1][j - 1]。
 * 也可以用二维数组，这里图省事，直接用滚动数组了。
 */
