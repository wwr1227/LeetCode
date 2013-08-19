public class Solution {
    public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null || matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRow = false;
		boolean firstCol = false;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstCol = true;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				firstRow = true;
				break;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		// print(matrix);
		for (int i = 1; i < m; i++)
			if (matrix[i][0] == 0)
				for (int j = 1; j < n; j++)
					matrix[i][j] = 0;

		for (int i = 1; i < n; i++)
			if (matrix[0][i] == 0)
				for (int j = 1; j < m; j++)
					matrix[j][i] = 0;

		if (firstCol)
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;

		if (firstRow)
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;
		//print(matrix);
	}
}
