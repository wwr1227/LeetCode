package SetMatrixZeroes;

public class Solution {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null)
			return;
		int height = matrix.length;
		if (height == 0)
			return;
		int width = matrix[0].length;
		int[] row = new int[height];
		int[] col = new int[width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		for (int i = 0; i < height; i++) {
			if (row[i] == 1) {
				for (int j = 0; j < width; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < width; j++) {
			if (col[j] == 1) {
				for (int i = 0; i < height; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
