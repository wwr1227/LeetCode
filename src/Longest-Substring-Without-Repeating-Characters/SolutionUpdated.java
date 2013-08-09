public class Solution {
  public int lengthOfLongestSubstring(String s) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0)
			return 0;

		int len = s.length();
		Map<Character, Integer> noDup = new HashMap<Character, Integer>();
		int size = 0;
		int ans = 0;
		for (int i = 0; i < len; i++) {
			char cur = s.charAt(i);
			if (!noDup.containsKey(cur)) {
				noDup.put(cur, i);
				size++;
			} else {
				i = noDup.get(cur);
				noDup.clear();
				size = 0;
			}
			if (size > ans)
				ans = size;
		}
		return ans;
	}
}
