//Time complexity:O(n)
public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
      if(height==null || height.length==0)
			return 0;
	int ans = 0;
	int i = 0;
	int j=height.length-1;
	while(i<j){
		ans = Math.max(ans, Math.min(height[i],height[j])*(j-i));
		if(height[i]<height[j])
			i++;
		else
			j--;
	}
	return ans;
    }
} 
