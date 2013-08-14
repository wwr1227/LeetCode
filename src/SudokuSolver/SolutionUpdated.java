public class Solution {
    public boolean solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(board==null||board.length<=0)
			return false;
			
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j]=='.'){
					for(board[i][j]='1';board[i][j]<='9';board[i][j]++){
						if(isValid(board,i,j)&&solveSudoku(board))
							return true;
						
					}
					board[i][j]='.';
					return false;
				}
			}
		}
		return true;
    }
	public boolean isValid(char[][]board, int x, int y){
		for(int i=0;i<board.length;i++){
			if(i!=y&&board[x][i]==board[x][y])
				return false;
			if(i!=x&&board[i][y]==board[x][y])
				return false;
		}
		
		for(int i=x/3*3;i<x/3*3+3;i++){
			for(int j=y/3*3;j<y/3*3+3;j++){
				if(i!=x&&j!=y&&board[x][y]==board[i][j])
					return false;
			}
		}
		return true;
	}
}
