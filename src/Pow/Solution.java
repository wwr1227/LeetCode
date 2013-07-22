package Pow;

public class Solution {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x == 0 && n != 0)
			return 0;
		if (n == 0)
			return 1;
		if (n > 0) {
			if (x < 0 && n % 2 == 0) {
				x = Math.abs(x);
				return getPow(x, n);
			}

			if (x < 0 && n % 2 != 0) {
				x = Math.abs(x);
				return 0 - getPow(x, n);
			}
			return getPow(x, n);
		} else if (n < 0) {
			long nn = 0 - (long) n;
			if (x < 0 && nn % 2 == 0) {
				x = Math.abs(x);
				return 1 / getPow(x, nn);
			}

			if (x < 0 && nn % 2 != 0) {
				x = Math.abs(x);
				return 0 - (1 / getPow(x, nn));
			}
			return 1 / getPow(x, nn);
		}
		return 0;
	}

	public double getPow(double x, long n) {

		if (n == 1)
			return x;
		double temp = getPow(x, (n / 2));
		if (n % 2 == 0)
			return temp * temp;

		return x * temp * temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 0.00001;
		int n = 2147483647;
		Solution soluton = new Solution();
		System.out.println(soluton.pow(x, n));
	}
}