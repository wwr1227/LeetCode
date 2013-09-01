//Time complexity:O(logn)
public class Solution {
    public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x == 0 && n == 0)
			return 1;
		if (x == 0)
			return 0;
		if (n < 0)
			x = 1 / x;
		return getPow(x, n);
	}

	public double getPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1 || n == -1)
			return x;
		double tempPow = getPow(x, n / 2);
		if (n % 2 == 0)
			return tempPow * tempPow;
		else
			return tempPow * tempPow * x;
	}
}
