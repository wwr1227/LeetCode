//Time complexity:O(n)
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null||prices.length==0||prices.length==1)
            return 0;
        int len = prices.length;
        int buy =0;
        int maxProfit = 0;
        for(int i=1;i<len-1;i++){
            if(prices[i]<prices[i-1] && prices[i]<=prices[i+1])
                buy=i;
            if(prices[i]>prices[i-1] && prices[i]>=prices[i+1]){
                maxProfit+=prices[i]-prices[buy];
                buy=i+1;
            }
        }
        if(prices[len-1]>prices[buy]){
            maxProfit+=prices[len-1]-prices[buy];
        }
        return maxProfit;
    }
}
