public class Solution {
	public boolean isValidSudoku(char[][] board) {
	// Start typing your Java solution below
	// DO NOT write main() function
		if(board==null || board.length==0)
			return false;
		int len = board.length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				if(board[i][j]=='.')
					continue;
				if(!isValid(board,i,j))
					return false;
			}
		}
		return true;
	}
	public boolean isValid(char[][] board, int x, int y){
		for(int i=0;i<board.length;i++){
			if(y!=i&&board[x][y]==board[x][i])
				return false;
			if(x!=i&&board[i][y]==board[x][y])
				return false;
		}
	
		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++)
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++)
				if (!(i == x && j == y) && board[i][j] == board[x][y]) 
				return false;
		
		return true;
	}
}
