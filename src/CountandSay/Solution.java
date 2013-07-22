package CountandSay;

public class Solution {
	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n <= 0)
			return "";

		String[] say = new String[n + 1];
		say[0] = "";
		for (int i = 1; i <= n; i++) {
			say[i] = count(say[i - 1]);
		}
		return say[n];
	}

	public String count(String s) {

		if (s == "")
			return "1";
		int count = 1;
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			count = 1;

			while (i + 1 < s.length() && cur == s.charAt(i + 1)) {
				count++;
				i++;
			}

			ans += String.valueOf(count) + cur;
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		for (int i = 1; i <= 6; i++) {
			System.out.println(su.countAndSay(i));
		}
	}

}
