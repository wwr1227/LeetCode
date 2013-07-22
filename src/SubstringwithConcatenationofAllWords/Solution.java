package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ans = new ArrayList<Integer>();

		if (S == null || S.length() == 0)
			return ans;
		if (L == null || L.length == 0)
			return ans;

		int sLen = S.length();

		int wordNum = L.length;
		int wordLen = L[0].length();

		int subLen = wordNum * wordLen;

		if (sLen < subLen)
			return ans;

		Map<String, Integer> words = new HashMap<String, Integer>();
		for (int i = 0; i < wordNum; i++) {
			if (words.containsKey(L[i]))
				words.put(L[i], words.get(L[i]) + 1);
			else
				words.put(L[i], 1);
		}

		for (int i = 0; i < sLen - subLen + 1; i++) {
			int j = 0;
			HashMap<String, Integer> dic = new HashMap<String, Integer>(words);
			String subString = S.substring(i, i + subLen);

			while (j < wordNum) {
				String compare = subString.substring(j * wordLen, j * wordLen
						+ wordLen);

				if (dic.containsKey(compare)) {
					if (dic.get(compare) == 1)
						dic.remove(compare);
					else
						dic.put(compare, dic.get(compare) - 1);

					if (dic.isEmpty()) {
						ans.add(i);
						break;
					}

				} else {
					break;
				}
				j++;
			}

		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "aaa";
		String[] L = { "a", "a" };
		Solution su = new Solution();
		System.out.println(su.findSubstring(S, L));
	}
}
