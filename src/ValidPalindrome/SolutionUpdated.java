public class Solution {
	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null)
			return false;
		if (s.length() == 0)
			return true;
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			while (i < j && !check(s.charAt(i)))
				i++;
			while (i < j && !check(s.charAt(j)))
				j--;
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean check(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
			return true;
		else
			return false;
	}
}
