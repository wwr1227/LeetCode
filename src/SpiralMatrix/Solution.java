package SpiralMatrix;

import java.util.ArrayList;

public class Solution {

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		if (matrix == null)
			return ans;
		if (matrix.length == 0)
			return ans;
		else if (matrix[0].length == 0)
			return ans;

		int rows = matrix.length;
		int cols = matrix[0].length;
		if (rows == 1) {
			for (int i = 0; i < cols; i++)
				ans.add(matrix[0][i]);
			return ans;
		}

		if (cols == 1) {
			for (int i = 0; i < rows; i++)
				ans.add(matrix[i][0]);
			return ans;
		}

		int tempRow = rows;
		int tempCol = cols;

		int rowEnd = rows;
		int colEnd = cols;

		int circleNum = getMin(rows, cols) / 2;

		for (int i = 0; i < circleNum; i++) {
			// start a[i][i]
			for (int j = i; j < colEnd; j++) {
				ans.add(matrix[i][j]);
			}

			// start a[tempCol-1][i+1]
			for (int j = i + 1; j < rowEnd; j++) {
				ans.add(matrix[j][colEnd - 1]);
			}

			if (colEnd - i >= 2) {
				// start a[tempCol-2][tempRow-1]
				for (int j = colEnd - 2; j >= i; j--) {
					ans.add(matrix[rowEnd - 1][j]);
				}
			}

			if (rowEnd - i >= 2) {
				// start a[tempRow-1][i-1]
				for (int j = rowEnd - 2; j >= i + 1; j--) {
					ans.add(matrix[j][i]);
				}
			}

			tempRow -= 2;
			tempCol -= 2;
			rowEnd--;
			colEnd--;

		}

		if (tempRow == 1 && tempCol == 1) {
			ans.add(matrix[circleNum][circleNum]);
		} else if (tempCol > 1 && tempRow == 1) {
			for (int j = circleNum; j < colEnd; j++) {
				ans.add(matrix[circleNum][j]);
			}
		} else if (tempRow > 1 && tempCol == 1) {
			for (int j = circleNum; j < rowEnd; j++) {
				ans.add(matrix[j][circleNum]);
			}
		}
		return ans;
	}

	public int getMin(int a, int b) {
		return a > b ? b : a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		/**
		 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
		 */
		int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 }, { 19, 20, 21, 22, 23, 24 },
				{ 25, 26, 27, 28, 29, 30 } };
		System.out.println(su.spiralOrder(matrix));
	}
}
/**
 * 
 [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
 * [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12]
 * [1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13]
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
