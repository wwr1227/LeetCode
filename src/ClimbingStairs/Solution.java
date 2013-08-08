public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(n<=1)
			return 1;
		int ans = 0;
		int f0=1;
		int f1=1;
		for(int i=2;i<=n;i++){
			ans = f0 + f1;
			f0 = f1;
			f1 = ans;
		}
		return ans;
    }
}
