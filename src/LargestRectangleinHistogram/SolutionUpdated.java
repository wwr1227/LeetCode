public class Solution {
     public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height==null||height.length==0)
    		return 0;
		int n = height.length;
		int ans = 0;
		int[]left=new int[n];
		int[]right=new int[n];
		for(int j=0;j<n;j++){
			left[j]=j-1;
			while(left[j]!=-1&&height[j]<=height[left[j]]){
				left[j]=left[left[j]];
			}
		}
		for(int j=n-1;j>=0;j--){
			right[j]=j+1;
			while(right[j]!=n&&height[j]<=height[right[j]]){
				right[j]=right[right[j]];
			}
		}
		for(int j=0;j<n;j++){
			ans = Math.max(ans,(right[j]-left[j]-1)*height[j]);
		}	
        return ans;
    }
}
