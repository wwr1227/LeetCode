package StringtInteger_atoi;

public class Solution {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null || str.length() == 0)
			return 0;
		int len = str.length();
		int sign = 1;
		long ans = 0;
		boolean canSign = true;
		int start = 0;
		while (start < len && str.charAt(start) == ' ') {
			start++;
		}
		for (int i = start; i < len; i++) {

			if (str.charAt(i) == ' ') {
				break;
			} else if (str.charAt(i) == '+') {
				if (!canSign)
					return 0;
				sign = 1;
				canSign = false;
			} else if (str.charAt(i) == '-') {
				if (!canSign)
					return 0;
				sign = -1;
				canSign = false;
			} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				ans = ans * 10 + (str.charAt(i) - '0');

			} else {
				Long res = new Long(ans * sign);
				if (res > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if (res < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				return res.intValue();
			}

		}
		Long res = new Long(ans * sign);
		if (res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if (res < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return res.intValue();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String str = "2147483648";
		System.out.println(su.atoi(str));
	}

}
/**
 * "2147483648" -2147483648 2147483647
 * 
 * "-2147483649" 2147483647 -2147483648
 */
