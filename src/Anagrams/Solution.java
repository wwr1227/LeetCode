package Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	private static final Arrays Colletions = null;

	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
		if (strs == null || strs.length == 0 || strs.length == 1)
			return ans;
		Map<String, String> ana = new HashMap<String, String>();
		int len = strs.length;
		for (int i = 0; i < len; i++) {
			String s = strs[i];
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			String sKey = String.valueOf(charArray);
			if (ana.containsKey(sKey)) {
				if (!ans.contains(ana.get(sKey)))
					ans.add(ana.get(sKey));
				ans.add(s);
			} else
				ana.put(sKey, s);
		}
		Collections.sort(ans);
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
