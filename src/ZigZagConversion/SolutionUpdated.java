public class Solution {
  public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (s == null || s.length() == 0 || nRows <= 0)
			return "";
		if (nRows == 1)
			return s;
		int len = s.length();
		String res = "";

		int iterLen = nRows * 2 - 2;
		for (int i = 0; i < nRows; i++) {
			for (int j = i; j < len; j += iterLen) {
				res += s.charAt(j);
				if (i == 0 || i == nRows - 1)
					continue;
				if (j + (nRows - i) * 2 - 2 < len)
					res += s.charAt(j + (nRows - i) * 2 - 2);
			}
		}

		return res;
	}
}
