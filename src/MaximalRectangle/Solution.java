package MaximalRectangle;

public class Solution {
	public int maximalRectangle(char[][] matrix) {

		if (matrix == null)
			return 0;
		if (matrix.length == 0)
			return 0;
		int height = matrix.length;
		int width = matrix[0].length;

		int[][] ans = new int[height + 1][width + 1];
		for (int i = 0; i <= height; i++) {
			for (int j = 0; j <= width; j++) {
				ans[i][j] = 0;
			}
		}

		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (matrix[i - 1][j - 1] == '1')
					ans[i][j] = 1;
			}
		}

		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (ans[i][j] == 1) {
					ans[i][j] += ans[i][j - 1];
				}
			}
		}

		return 0;
		// Start typing your Java solution below
		// DO NOT write main() function

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
