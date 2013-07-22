package RotateImage;

public class Solution {
	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null)
			return;
		int n = matrix.length;
		if (n == 0)
			return;

		for (int i = 0; i < n - 1; i++) {
			int len = n - i;
			for (int j = 0; j < len; j++) {
				swap(matrix, i, j, n - j - 1, n - i - 1);
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				swap(matrix, i, j, n - i - 1, j);
			}
		}

	}

	public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
		int temp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = temp;
	}
}