//O(log(m*n))
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(matrix==null||matrix.length==0)
			return false;
		
		int m=matrix.length;
		int n=matrix[0].length;
		int left=0;
		int right=m*n-1;
		while(left<=right){
			int mid = left+(right-left)/2;
			int row=mid/n;
			int col=mid%n;
			if(matrix[row][col]==target)
				return true;
			else if(matrix[row][col]>target)
				right=mid-1;
			else
				left=mid+1;
		}
        return false;
    }
}
