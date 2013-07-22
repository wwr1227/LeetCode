package isScramble;

import java.util.Arrays;

public class Solution {
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		if (len == 0) {
			return true;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		if (len == 1) {
			return c1[0] == c2[0];
		}
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < len; ++i) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		boolean result = false;
		for (int i = 1; i < len && !result; i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			String s31 = s2.substring(0, len - i);
			String s32 = s2.substring(len - i);
			result = isScramble(s11, s21) && isScramble(s12, s22);
			if (!result) {
				result = isScramble(s11, s32) && isScramble(s12, s31);
			}
		}
		return result;

	}
}