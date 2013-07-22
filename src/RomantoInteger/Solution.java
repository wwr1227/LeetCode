package RomantoInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		int ans = 0;
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (i + 1 < s.length()
					&& romanMap.get(cur) < romanMap.get(s.charAt(i + 1))) {
				ans -= romanMap.get(cur);
			} else
				ans += romanMap.get(cur);

		}

		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
