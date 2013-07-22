package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
		if (n < 0)
			return ans;

		if (n == 0) {
			ans.add("");
			return ans;
		}
		StringBuffer item = new StringBuffer();
		int index = 0;
		generateParenthesisHelper(ans, 0, 0, n, item, index);

		return ans;
	}

	public void generateParenthesisHelper(ArrayList<String> ans, int left,
			int right, int n, StringBuffer item, int index) {
		if (index == 2 * n) {
			ans.add(item.toString());
			return;
		}

		if (left < n) {
			item.append("(");
			generateParenthesisHelper(ans, left + 1, right, n, item, index + 1);
			item.setLength(item.length() - 1);
		}
		if (right < left) {
			item.append(")");
			generateParenthesisHelper(ans, left, right + 1, n, item, index + 1);
			item.setLength(item.length() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		System.out.println(s.substring(0, s.length() - 1));

		Solution su = new Solution();

		int n = 3;
		System.out.println(su.generateParenthesis(n));
	}
}
