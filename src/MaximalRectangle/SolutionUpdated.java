public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix==null||matrix.length==0)
    		return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = 0;
		int[] height = new int[n];
		int[]left=new int[n];
		int[]right=new int[n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j]=='1')
					height[j]= height[j]+1;
				else
					height[j]=0;
			}			
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
		}
        return ans;
    }
}
