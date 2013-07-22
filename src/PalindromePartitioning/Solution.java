package PalindromePartitioning;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();

		if (s == null || s.length() == 0)
			return ans;

		ArrayList<String> item = new ArrayList<String>();

		DFS(ans, item, s, 0);
		return ans;
	}

	public void DFS(ArrayList<ArrayList<String>> ans, ArrayList<String> item,
			String s, int start) {
		if (start == s.length()) {
			ans.add(new ArrayList<String>(item));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				item.add(s.substring(start, i + 1));
				DFS(ans, item, s, i + 1);
				item.remove(item.size() - 1);
			}
		}

	}

	/**
	 * isPalindrome 这里可以事先预处理 开个二维数组 算出所有的子串是否是回文的 这样以后每次就可以查表 能避免大量的重复计算
	 * 
	 * @param s
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String s = "abbab";
		System.out.println(su.partition(s));
	}
	/**
	 * 
	 "abbab"
	 * [["a","b","b","a","b"],["a","a","bab"],["a","bb","a","b"],["abba","b"]]
	 * [["a","b","b","a","b"],["a","b","bab"],["a","bb","a","b"],["abba","b"]]
	 */
}
