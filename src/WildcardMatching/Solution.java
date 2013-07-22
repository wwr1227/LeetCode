package WildcardMatching;

public class Solution {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int plen = p.length();
		int slen = s.length();
		int sIndex = 0, pIndex = 0;
		int first = -1, attemp = -1;
		while (pIndex < plen) {
			if (s.charAt(sIndex) == p.charAt(pIndex)) {
				sIndex++;
				pIndex++;
			} else if (p.charAt(pIndex) == '?') {
				sIndex++;
				pIndex++;
			} else if (p.charAt(pIndex) == '*') {
				first = pIndex;
				attemp = sIndex;
				pIndex++;
			} else {
				if (first != -1) {
					attemp++;
				} else
					return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
