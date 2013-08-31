public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(n<0)
			return null;
		int [][] ans = new int[n][n];
		int start = 0;
		int end = n-1;
		int num=1;
		while(start<end){
			for(int i=start;i<end;i++)
				ans[start][i]=num++;
			for(int i=start;i<end;i++)
				ans[i][end]=num++;
			for(int i=end;i>start;i--)
				ans[end][i]=num++;
			for(int i=end;i>start;i--)
				ans[i][start]=num++;
			start++;
			end--;
		}
		if(start==end)
			ans[start][end]=num;
		return ans;
    }
}
