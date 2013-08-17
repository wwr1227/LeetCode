public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle == null || triangle.size()==0)
            return 0;
        int minValue = Integer.MAX_VALUE;
        int[] dp = new int[triangle.size()];
        dp[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=triangle.get(i).size()-1; j>=0;j--){
                if(j==triangle.get(i).size()-1)
                    dp[j] = dp[j-1]+triangle.get(i).get(j);
                else if(j==0)
                    dp[j] = dp[j]+triangle.get(i).get(j);
                else
                    dp[j] = Math.min(dp[j],dp[j-1])+triangle.get(i).get(j);
            }
        }
        for(int i=0;i<triangle.size();i++){
            if(minValue>dp[i])
                minValue = dp[i];
        }
        return minValue;
    }
}
