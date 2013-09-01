//Time complexity:O(n)
public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ans=0;
        if(n<=1) return n;
        int f0=1;
        int f1=1;
        for(int i=2;i<=n;i++){
            ans=f0+f1;
            f0=f1;
            f1=ans;
        }
        return ans;
    }
}
