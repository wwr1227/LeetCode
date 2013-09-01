////Time complexity:O(logn*logn)
public class Solution {
	public int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (divisor == 0)
			return 0;

		Long dividendL = new Long(dividend);
		Long divisorL = new Long(divisor);
		int sign = 1;
		if (dividendL < 0 && divisorL < 0) {
			sign = 1;
			dividendL = 0 - dividendL;
			divisorL = 0 - divisorL;
		} else if (dividendL < 0 || divisorL < 0) {
			sign = -1;
			dividendL = dividendL > 0 ? dividendL : 0 - dividendL;
			divisorL = divisorL > 0 ? divisorL : 0 - divisorL;
		}
		int ans = 0;
		while (divisorL <= dividendL) {
			Long index = 1L;
			Long sum = divisorL;
			while (sum + sum <= dividendL) {
				sum += sum;
				index += index;
			}
			dividendL -= sum;
			ans += index;
		}
		if (sign < 0)
			return 0 - ans;
		else
			return ans;
	}

	public static void main(String[] args) {
		int a = -2147483648;
		int b = -2147483648;
		System.out.println(new Solution().divide(a, b));
	}
}
