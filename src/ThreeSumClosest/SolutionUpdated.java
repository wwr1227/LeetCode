public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(num==null||num.length==0)
			return 0;
		Arrays.sort(num);		
		int diff=Integer.MAX_VALUE;
		int ans = 0;
		for(int i=0;i<num.length-2;i++){
			int curTarget= target-num[i];
			int left=i+1;
			int right=num.length-1;
			while(left<right){
				if(num[left]+num[right]==curTarget)
					return target;
				else if (num[left]+num[right]>curTarget){
					if(diff>num[left]+num[right]-curTarget){
						ans = num[left]+num[right]+num[i];
						diff=num[left]+num[right]-curTarget;
					}
					right--;
				}else{
					if(diff>curTarget-(num[left]+num[right])){
						ans = num[left]+num[right]+num[i];
						diff=curTarget-(num[left]+num[right]);
					}
					left++;
				}
			}
		}
        return ans;
    }
}
