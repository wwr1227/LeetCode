//O(n^2)
public class Solution {
    	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
    		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(matrix==null||matrix.length==0)
			return ans;
		int start_X=0;
		int start_Y=0;
		int end_X=matrix[0].length-1;
		int end_Y=matrix.length-1;
		while(true){
			for(int i=start_X;i<=end_X;i++)
				ans.add(matrix[start_Y][i]);
			if(++start_Y>end_Y)
				break;
			for(int i=start_Y;i<=end_Y;i++)
				ans.add(matrix[i][end_X]);
			if(--end_X<start_X)
				break;
			for(int i=end_X;i>=start_X;i--)
				ans.add(matrix[end_Y][i]);
			if(--end_Y<start_Y)
				break;
			for(int i=end_Y;i>=start_Y;i--)
				ans.add(matrix[i][start_X]);
			if(++start_X>end_X)
				break;
		}
        	return ans;
    	}
}
