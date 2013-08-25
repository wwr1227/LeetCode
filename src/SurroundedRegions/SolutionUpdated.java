public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board==null|| board.length==0)
            return;
        for(int i=0;i<board.length;i++){
            DFS(board,i,0,'O','#');
            DFS(board,i,board[0].length-1,'O','#');
        }
        for(int i=0;i<board[0].length;i++){
            DFS(board,0,i,'O','#');
            DFS(board,board[0].length-1,i,'O','#');
        }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='O')
                    board[i][j]='X';
       for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]=='#')
                    board[i][j]='O';
    }
    public void DFS(char[][] board, int x,int y, char orgin, char change){
        if(x<0||x>board.length||y<0|| y>board[0].length)
            return;
        if(board[x][y]==orgin){  
            board[x][y]=change;
            if(x+1<board.length)
                DFS(board,x+1,y,orgin,change);
            if(y+1<board.length)
                DFS(board,x,y+1,orgin,change);
            if(x-1>=0)
                DFS(board,x-1,y,orgin,change);
            if(y-1>=0)
                DFS(board,x,y-1,orgin,change);
        }
    }
}
