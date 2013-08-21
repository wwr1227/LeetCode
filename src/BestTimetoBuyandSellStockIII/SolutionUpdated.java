public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if(prices==null || prices.length<=1)
			return 0;
		int len = prices.length;
		int[] firstProfile = new int[len];
		int[] secondProfile = new int[len];
			
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int maxProfile=0;
		for(int i=0;i<len; i++){
			min=Math.min(min,prices[i]);
			maxProfile=Math.max(maxProfile,prices[i]-min);
			firstProfile[i]=maxProfile;
		}
		maxProfile=0;
		for(int i=len-1;i>=0; i--){
			max=Math.max(max,prices[i]);
			maxProfile=Math.max(maxProfile,max-prices[i]);
			secondProfile[i]=maxProfile;
		}
		int ans=0;
		for(int i=0;i<len;i++){
			ans=Math.max(firstProfile[i]+secondProfile[i], ans);
		}
        return ans;
    }
}
