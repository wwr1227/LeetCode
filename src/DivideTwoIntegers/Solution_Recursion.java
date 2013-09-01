//Time complexity:O(logn)
class DivideModel {
    long num;

	public DivideModel(long num) {
		this.num = num;
	}
}

public class Solution {
	public int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (divisor == 0 || divisor == 0)
			return 0;
		boolean isNeg = (dividend > 0) ^ (divisor > 0);
		long dividendL = (long) dividend;
		long divisorL = (long) divisor;
		if (dividendL < 0)
			dividendL = 0 - dividendL;
		if (divisorL < 0)
			divisorL = 0 - divisorL;
		long ans = div(new DivideModel(dividendL), divisorL);
		if (isNeg)
			return (int) (0 - ans);
		else
			return (int) ans;
	}

	public long div(DivideModel dividend, long divisor) {
		if (dividend.num < divisor)
			return 0L;
		long res = div(dividend, divisor + divisor);
		res = res + res;
		if (dividend.num >= divisor) {
			res++;
			dividend.num -= divisor;
		}
		return res;
	}
}
