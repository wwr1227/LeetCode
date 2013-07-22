package UniquePathsII;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (obstacleGrid == null)
			return 0;
		if (obstacleGrid.length == 0)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] path = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				path[i][j] = 0;
		boolean block = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				block = true;
			if (!block)
				path[i][0] = 1;
		}
		block = false;
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				block = true;
			if (!block)
				path[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0)
					path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}
		return obstacleGrid[m - 1][n - 1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[][] obstacleGrid = { { 0, 0 } };
		System.out.println(su.uniquePathsWithObstacles(obstacleGrid));
	}

}
