//O(n^2)
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(n<=1)
		return 1;
	
	int [] dp = new int[n+1];
	dp[0]=dp[1]=1;
	for(int i=2;i<=n;i++)
		for(int j=0;j<i;j++)
			dp[i]+=dp[j]*dp[i-j-1];
	
        return dp[n];
    }
}
