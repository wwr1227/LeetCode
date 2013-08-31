public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
    		return 0;
	int[] dp = new int[s.length() + 1];
	char[] str = s.toCharArray();
	dp[0] = 1;
	for (int i = 1; i <= str.length; i++) {
		if (str[i - 1] != '0')
			dp[i] += dp[i - 1];
		if (i > 1 && str[i - 2] != '0') {
			int sum = Character.getNumericValue(str[i - 2]) * 10
					+ Character.getNumericValue(str[i - 1]);
			if (sum > 0 && sum <= 26)
				dp[i] += dp[i - 2];
		}
	}
	return dp[s.length()];
    }
}
