package DivideTwoIntegers;

public class Solution {
	public int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int sign = 1;

		if (dividend == 0)
			return 0;

		Long dividendL = new Long(dividend);
		Long divisorL = new Long(divisor);

		if (dividend < 0) {
			dividendL = -dividendL;
			sign *= -1;
		}
		if (divisor < 0) {
			divisorL = -divisorL;
			sign *= -1;
		}
		int ans = 0;

		while (dividendL >= divisorL) {
			int count = 1;
			long sum = divisorL;

			while (dividendL >= sum + sum) {
				sum += sum;
				count += count;
			}
			dividendL -= sum;
			ans += count;
		}

		return ans * sign;
	}
}
