//o(n)
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pre = 0;
        int []dp = new int[A.length];
        dp[0]=0;
        for(int i=1;i<A.length;i++){
            for(;pre<i&&pre+A[pre]<i;pre++);
            dp[i]=dp[pre]+1;                
        }
        return dp[A.length-1];
    }
}
