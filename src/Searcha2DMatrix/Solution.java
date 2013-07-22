package Searcha2DMatrix;

public class Solution {
	private int row = -1;

	public boolean searchMatrix(int[][] matrix, int target) {

		row = -1;
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null)
			return false;

		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		if (m == 1)
			return searchMatrixHelper2(matrix[0], target, 0, n - 1);
		else {
			if (matrix[0][0] >= target) {
				row = 0;
			}
			if (matrix[m - 1][0] <= target) {
				row = m - 1;
			}
			if (row == -1) {
				searchMatrixHelper1(matrix, target, 0, m - 2);
			}
			// System.out.println(row);
			return searchMatrixHelper2(matrix[row], target, 0, n - 1);
		}
	}

	public void searchMatrixHelper1(int[][] matrix, int target, int up, int down) {

		if (up > down)
			return;

		int mid = (up + down) / 2;
		if ((target > matrix[mid][0] && target < matrix[mid + 1][0])
				|| matrix[mid][0] == target) {
			row = mid;
			return;
		} else if (matrix[mid][0] > target) {
			searchMatrixHelper1(matrix, target, up, mid - 1);
		} else {
			searchMatrixHelper1(matrix, target, mid + 1, down);
		}
	}

	public boolean searchMatrixHelper2(int[] matrix, int target, int left,
			int right) {

		if (left > right)
			return false;
		int mid = (left + right) / 2;
		if (matrix[mid] == target)
			return true;
		if (matrix[mid] > target) {
			return searchMatrixHelper2(matrix, target, left, mid - 1);
		} else {
			return searchMatrixHelper2(matrix, target, mid + 1, right);
		}

		// return false;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
		// { 23, 30, 34, 50 } };
		int[][] matrix = { { 1 }, { 3 }, { 5 } };
		int target = 3;
		System.out.println(su.searchMatrix(matrix, target));
	}
}