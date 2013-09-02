//O(n^2)
public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {

		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		ArrayList<String> item = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return ans;
		boolean[][] isPa = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--)
			for (int j = i; j < s.length(); j++)
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || isPa[i + 1][j - 1]))
					isPa[i][j] = true;
		partitionHelper(s, 0, isPa, ans, item);
		return ans;
	}

	public void partitionHelper(String s, int start, boolean[][] isPa,
			ArrayList<ArrayList<String>> ans, ArrayList<String> item) {

		if (start == s.length()) {
			ans.add(new ArrayList<String>(item));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPa[start][i]) {
				item.add(s.substring(start, i + 1));
				partitionHelper(s, i + 1, isPa, ans, item);
				item.remove(item.size() - 1);
			}
		}
	}
}
