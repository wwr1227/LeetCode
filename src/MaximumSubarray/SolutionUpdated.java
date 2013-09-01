//Time complexity:O(n)
public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null||A.length==0)
            return 0;
        int maxSub = A[0];
        int sum=A[0];
        for(int i=1;i<A.length;i++){
            if(sum<0)
                sum=0;
            sum+=A[i];
            maxSub=Math.max(maxSub,sum); 
        }
        return maxSub;
    }
}
