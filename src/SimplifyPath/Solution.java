package SimplifyPath;

import java.util.Stack;

public class Solution {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (path == null)
			return path;
		int len = path.length();
		if (len == 0)
			return path;

		Stack<String> sk = new Stack<String>();
		String dot = "";
		String file = "";
		for (int i = 0; i < len; i++) {
			if (path.charAt(i) == '/') {
				if (file != "") {
					sk.push(dot + file);
					file = "";
				} else if (dot.equals("..")) {
					if (!sk.isEmpty())
						sk.pop();
				}
				dot = "";
			} else if (path.charAt(i) == '.') {
				dot += ".";
			} else {
				file += path.charAt(i);
			}
		}
		if (dot.equals("..")) {
			if (!sk.isEmpty())
				sk.pop();
			dot = "";
		}
		if (file != "") {
			sk.push(dot + file);
			file = "";
			dot = "";
		}
		if (sk.isEmpty())
			return "/";
		String ansStr = "";
		while (!sk.isEmpty()) {
			ansStr = "/" + sk.pop() + ansStr;
		}

		if (ansStr.endsWith("/"))
			ansStr = ansStr.substring(0, ansStr.length());

		return ansStr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String path = "/home/foo/./.././bar";
		System.out.println(su.simplifyPath(path));
	}

}
