public class Solution {
    public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x <= 0)
			return x;
		long xL = (long) x;
		long l = 0;
		long r = xL;
		while (l <= r) {
			long m = l + (r - l) / 2;
			if (m * m == xL) {
				return (int) m;
			} else if (m * m > xL) {
				r = m - 1;
			} else
				l = m + 1;
		}
		return (int) r;// Integer.valueOf(String.valueOf(r));
	}
}
