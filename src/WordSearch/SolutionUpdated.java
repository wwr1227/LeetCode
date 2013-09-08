//O(m*n*4^|word|) 
public class Solution {
    public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length == 0)
			return false;
		if (word == null || word.length() == 0)
			return true;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				visited[i][j] = false;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (DFS(board, i, j, 0, word, visited))
					return true;
		return false;
	}

	public boolean DFS(char[][] board, int i, int j, int len, String target,
			boolean[][] visited) {

		if (visited[i][j] || board[i][j] != target.charAt(len))
			return false;
		if (len == target.length() - 1)
			return true;
		visited[i][j] = true;
		if (i != board.length - 1
				&& DFS(board, i + 1, j, len + 1, target, visited))
			return true;
		if (j != board[0].length - 1
				&& DFS(board, i, j + 1, len + 1, target, visited))
			return true;
		if (i != 0 && DFS(board, i - 1, j, len + 1, target, visited))
			return true;
		if (j != 0 && DFS(board, i, j - 1, len + 1, target, visited))
			return true;
		visited[i][j] = false;
		return false;
	}
}
