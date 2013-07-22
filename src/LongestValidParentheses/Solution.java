package LongestValidParentheses;

import java.util.Stack;

public class Solution {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null)
			return 0;
		int len = s.length();
		if (len == 0)
			return 0;
		int ans = 0;
		Stack<Integer> sk = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				sk.push(i);
			} else {
				if (!sk.isEmpty() && s.charAt(sk.peek()) == '(') {
					sk.pop();
					int temp;
					if (sk.isEmpty())
						temp = -1;
					else
						temp = sk.peek();

					ans = Math.max(i - temp, ans);
				} else {
					sk.push(i);
				}
			}
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(((((()())()()))()(()))(";
		System.out.println(new Solution().longestValidParentheses(s));
	}

}
