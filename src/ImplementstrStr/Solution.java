package ImplementstrStr;

public class Solution {
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (needle.length() == 0 && haystack.length() == 0)
			return haystack;
		if (needle.length() == 0)
			return haystack;
		if (haystack.length() == 0)
			return null;

		int nLen = needle.length();
		boolean find = false;
		int i = 0;
		for (; i < haystack.length() - nLen + 1; i++) {
			if (haystack.substring(i, i + nLen).equals(needle)) {
				find = true;
				break;
			}
		}

		if (!find)
			return null;
		else
			return haystack.substring(i);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
