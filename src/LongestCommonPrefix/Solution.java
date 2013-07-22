package LongestCommonPrefix;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		StringBuilder sb = new StringBuilder("");
		if (strs == null)
			return sb.toString();
		if (strs.length == 0)
			return sb.toString();
		if (strs.length == 1)
			return strs[0];

		int len = strs.length;
		for (int i = 0; i < len; i++)
			if (strs[i].length() == 0)
				return sb.toString();
		int indexStr = 0;
		int indexPos = 0;
		while (true) {
			indexStr = 0;
			if (indexPos < strs[indexStr].length()) {
				char prefix = strs[indexStr].charAt(indexPos);
				for (indexStr = 0; indexStr < len; indexStr++) {
					if (indexPos < strs[indexStr].length()) {
						if (strs[indexStr].charAt(indexPos) != prefix) {
							return sb.toString();
						}
					} else {
						return sb.toString();
					}
				}
				sb.append(prefix);
				indexPos++;
			} else {
				return sb.toString();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String[] strs = { "aa", "a" };
		System.out.println(su.longestCommonPrefix(strs));
	}

}
