//O(n)
public class Solution {
    public boolean isPalindrome(int x) {
  	// Start typing your Java solution below
		// DO NOT write main() function
        	if (x < 0)
    			return false;
		int divisor = 1;
		int xDummy = x;
		while (x / 10 != 0) {
			divisor *= 10;
			x /= 10;
		}
		while (xDummy != 0 && divisor != 0) {
			if (xDummy < 10 && xDummy > -10)
				return true;
			if ((xDummy / divisor) % 10 != xDummy % 10)
				return false;
			divisor /= 100;
			xDummy /= 10;
		}
		return true;
	}
}
