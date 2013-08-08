public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(matrix==null||matrix.length==0)
			return false;
		int heigh = matrix.length;
		int width = matrix[0].length;
		int i = 0;
		int j = width-1;
		while(i<height&&j>=0){
			if(matrix[i][j]==target)
				return true;
			else if(matrix[i][j]<target)
				i++;
			else if(matrix[i][j]>target)
				j--;
		}
		return false;        
    }
}
