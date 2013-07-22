package MaximalRectangle;

public class Solutionfzl {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (matrix == null)
			return 0;

		int rowLen = matrix.length;
		if (rowLen == 0)
			return 0;
		int colLen = matrix[0].length;

		int[] height = new int[colLen];
		int[] left = new int[colLen];
		int[] right = new int[colLen];

		int ans = 0;

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == '1')
					height[j] = height[j] + 1;
				else
					height[j] = 0;
			}

			for (int j = 0; j < colLen; j++) {
				left[j] = j - 1;
				while (left[j] != -1 && height[left[j]] >= height[j])
					left[j] = left[left[j]];
			}
			for (int j = colLen - 1; j >= 0; j--) {
				right[j] = j + 1;
				while (right[j] != colLen && height[right[j]] >= height[j])
					right[j] = right[right[j]];
			}

			for (int k = 0; k < colLen; k++) {
				ans = Math.max(ans, height[k] * (right[k] - left[k] - 1));
			}

		}
		return ans;
	}
}