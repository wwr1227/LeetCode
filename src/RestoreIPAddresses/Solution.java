package RestoreIPAddresses;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ipAdd = new ArrayList<String>();
		String IPstring = "";
		if (s == null || s.length() == 0)
			return ipAdd;
		getIpAddresses(s, ipAdd, IPstring, 0, 0);
		return ipAdd;

	}

	public void getIpAddresses(String s, ArrayList<String> ipAdd,
			String IPstring, int start, int pos) {
		if (start + 3 * (4 - pos) < s.length())
			return;
		if (start + 1 * (4 - pos) > s.length())
			return;
		if (start > s.length())
			return;
		if (pos == 4 && start == s.length()) {
			IPstring = IPstring.substring(0, IPstring.length() - 1);
			ipAdd.add(IPstring);
			return;
		} else {
			if (start + 1 <= s.length() && check(s.substring(start, start + 1))) {
				String curIP = IPstring + s.substring(start, start + 1) + ".";
				getIpAddresses(s, ipAdd, curIP, start + 1, pos + 1);
			}
			if (start + 2 <= s.length() && check(s.substring(start, start + 2))) {
				String curIP = IPstring + s.substring(start, start + 2) + ".";
				getIpAddresses(s, ipAdd, curIP, start + 2, pos + 1);
			}
			if (start + 3 <= s.length() && check(s.substring(start, start + 3))) {
				String curIP = IPstring + s.substring(start, start + 3) + ".";
				getIpAddresses(s, ipAdd, curIP, start + 3, pos + 1);

			}
		}
	}

	boolean check(String ip) {
		if (ip.length() == 1)
			return 0 <= Integer.parseInt(ip) && Integer.parseInt(ip) <= 9;
		else if (ip.length() == 2)
			return 10 <= Integer.parseInt(ip) && Integer.parseInt(ip) <= 99;
		else if (ip.length() == 3)
			return 100 <= Integer.parseInt(ip) && Integer.parseInt(ip) <= 255;
		else
			return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String s = "010010";
		System.out.println(su.restoreIpAddresses(s));
	}

}
