package SudokuSolver;

public class Solution {

	public boolean isValid(char[][] board, int x, int y, int numI) {
		int len = board.length;
		char num = Character.forDigit(numI, 10);
		for (int i = 0; i < len; i++) {
			if (i != y && board[x][i] == num)
				return false;
		}
		for (int i = 0; i < len; i++) {
			if (i != x && board[i][y] == num)
				return false;
		}
		int blockX = 3 * (int) (x / 3);
		int blockY = 3 * (int) (y / 3);
		for (int i = blockX; i < blockX + 3; i++) {
			for (int j = blockY; j < blockY + 3; j++) {
				if (i != x && j != y && board[i][j] == num)
					return false;
			}
		}
		return true;
	}

	public boolean solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int len = board.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] == '.') {
					for (int numI = 1; numI <= 9; numI++) {
						board[i][j] = Character.forDigit(numI, 10);
						if (isValid(board, i, j, numI) && solveSudoku(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * 
 [" 530276148"," 624195037"," 198034562"," 812567493"," 456803721","
 * 703921856"," 361750284"," 287419305"," 045382679"]
 */
