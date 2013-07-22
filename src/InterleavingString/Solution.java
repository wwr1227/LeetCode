package InterleavingString;

public class Solution {

	/**
	 * @param args
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len3 != len1 + len2)
			return false;

		boolean[][] match = new boolean[len1 + 1][len2 + 1];
		match[0][0] = true;

		for (int i = 1; i <= len2; i++) {
			if (s3.charAt(i - 1) == s2.charAt(i - 1))
				match[0][i] = true;
			else
				match[0][i] = false;
		}
		for (int i = 1; i <= len1; i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1))
				match[i][0] = true;
			else
				match[i][0] = false;
		}

		for (int i = 1; i <= len1; ++i) {
			for (int j = 1; j <= len2; ++j) {

				if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
					match[i][j] = match[i - 1][j] || match[i][j];

				if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
					match[i][j] = match[i][j - 1] || match[i][j];
			}
		}
		return match[len1][len2];

	}
}
