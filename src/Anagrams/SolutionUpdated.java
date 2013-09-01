//Time complexity:O(nmlogm)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return ans;
		HashMap<String, ArrayList<String>> anagram = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] array = strs[i].toCharArray();
			Arrays.sort(array);
			String sortedStr = String.valueOf(array);
			if (anagram.containsKey(sortedStr)) {
				ArrayList<String> tempAnagram = anagram.get(sortedStr);
				tempAnagram.add(strs[i]);
				anagram.put(sortedStr, tempAnagram);
			} else {
				ArrayList<String> newAnagram = new ArrayList<String>();
				newAnagram.add(strs[i]);
				anagram.put(sortedStr, newAnagram);
			}
		}
		for (Entry<String, ArrayList<String>> ana : anagram.entrySet()) {
			if (ana.getValue().size() <= 1)
				continue;
			for (String oneString : ana.getValue())
				ans.add(oneString);
		}

		return ans;
	}
}
