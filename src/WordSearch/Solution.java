package WordSearch;

public class Solution {

	int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// System.out.println(board[0].length);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (find(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean find(char[][] board, int i, int j, String word, int index) {

		
		if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
			System.out.println("OUT i:" + i + "; j:" + j);
			return false;
		}

		if (board[i][j] == word.charAt(index)) {
			
			board[i][j] = '*';
			for (int p = 0; p < board.length; p++) {
				for (int q = 0; q < board[0].length; q++) {
					System.out.print(board[p][q] + " ");
				}
				System.out.println();
			}
			System.out.println();
			index++;
			if (index == word.length() - 1)
				return true;
			for (int d = 0; d < direction.length; d++) {
				find(board, i + direction[d][0], j + direction[d][1], word,
						index);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution su = new Solution();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(su.exist(board, word));
	}
}
