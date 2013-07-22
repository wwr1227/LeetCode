package ValidParentheses;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (s == null)
			return true;
		int len = s.length();
		if (len == 0)
			return true;

		Stack<Character> sk = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			if (sk.isEmpty()) {
				sk.push(s.charAt(i));
			} else {
				char compare = sk.peek();

				if (left(s.charAt(i))) {
					sk.push(s.charAt(i));
				} else if (compare == pair(s.charAt(i))) {
					sk.pop();
				} else
					return false;
			}
		}
		if (sk.size() == 0)
			return true;
		else
			return false;
	}

	public boolean left(char s) {
		if (s == '[')
			return true;
		if (s == '{')
			return true;
		if (s == '(')
			return true;
		return false;
	}

	public char pair(char s) {
		if (s == ']')
			return '[';
		if (s == '}')
			return '{';
		if (s == ')')
			return '(';
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		System.out.println(su.isValid("([)[]{}"));
	}

}
