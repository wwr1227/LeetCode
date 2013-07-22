package LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length == 0)
			return 0;

		if (num.length == 1)
			return 1;

		int len = num.length;

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		boolean[] visited = new boolean[len];
		for (int i = 0; i < len; i++) {
			m.put(num[i], i);
			visited[i] = false;
		}
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int cur = num[i];
			visited[i] = true;
			int tempAns = 1;
			while (m.containsKey(--cur) && !visited[m.get(cur)]) {
				visited[m.get(cur)] = true;
				tempAns++;
			}
			cur = num[i];
			while (m.containsKey(++cur) && !visited[m.get(cur)]) {
				visited[m.get(cur)] = true;
				tempAns++;
			}
			if (tempAns > ans)
				ans = tempAns;
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
