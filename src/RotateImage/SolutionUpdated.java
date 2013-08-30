public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length==0)
    		return;
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m/2;i++){
			for(int j=i;j<n-i-1;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i]; 
				matrix[n-j-1][i]= matrix[m-i-1][n-j-1];
				matrix[m-i-1][n-j-1] = matrix[j][m-i-1];
				matrix[j][m-i-1]=temp;
			}
		}
    }
}
