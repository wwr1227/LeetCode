package ValidNumber;

public class Solution {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0)
			return false;
		int len = s.length();

		boolean hasNum = false;
		boolean canSign = true;
		boolean canDigital = true;
		boolean canE = true;
		boolean canSpace = true;
		boolean canDot = true;
		int end = len - 1;

		while (end >= 0 && s.charAt(end) == ' ') {
			end--;
		}

		for (int i = 0; i <= end; i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (canSign) {
					canSign = false;
					hasNum = false;
					canSpace = false;
				} else
					return false;
			} else if (s.charAt(i) == ' ') {
				if (canSpace) {
					if (hasNum) {
						canDigital = false;
						canDot = false;
						canE = false;
						canDot = false;
						canSign = false;
					}
				} else
					return false;
			} else if (s.charAt(i) == '.') {
				if (canDot) {
					canDot = false;
					canSign = false;
					canSpace = false;
				} else
					return false;
			} else if (s.charAt(i) == 'e') {
				if (canE && hasNum) {
					canSpace = false;
					canDot = false;
					canSign = true;
					canDigital = true;
					canSign = true;
					canE = false;
					hasNum = false;
				} else
					return false;
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (canDigital) {
					canSign = false;
					hasNum = true;
					canSpace = true;
				} else
					return false;
			} else
				return false;
		}
		if (!hasNum)
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String s = "   +2e-3   ";
		System.out.println(su.isNumber(s));
		String s2 = "   -2.34   ";
		System.out.println(su.isNumber(s2));
	}

}
