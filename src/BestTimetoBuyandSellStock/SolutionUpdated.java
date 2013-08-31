public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(prices==null||prices.length==0)
		return 0;
	int minPrice = Integer.MAX_VALUE;
	int maxProfit = 0;
	for(int i=0;i<prices.length;i++){
		minPrice=Math.min(minPrice,prices[i]);
		maxProfit=Math.max(maxProfit,prices[i]-minPrice);
	}
        return maxProfit;
    }
}
