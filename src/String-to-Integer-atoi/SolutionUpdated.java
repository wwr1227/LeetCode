//O(n)
public class Solution {

  public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (str == null || str.length() == 0)
			return 0;
		char[] strArray = str.toCharArray();
		int i = 0;
		int sign = 1;
		while (strArray[i] == ' ')
			i++;
		if (strArray[i] == '-' || strArray[i] == '+') {
			if (strArray[i] == '-')
				sign *= -1;
			i++;
		}
		Long ans = 0L;
		for (; i < strArray.length; i++) {
			if (strArray[i] <= '9' && strArray[i] >= '0') {
				ans *= 10;
				ans += Character.getNumericValue(strArray[i]);
			} else
				break;
		}
		ans = sign * ans;
		if (ans >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (ans <= Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return Integer.valueOf(ans.intValue());
	}
}
