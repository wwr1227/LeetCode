public class Solution {
    int totalQueens = 0;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] queens= new int[n];
        totalQueens=0;
        if(n<=0)
            return totalQueens;
        DFS(0,n,queens);
        return totalQueens;
    }
    public void DFS(int cur, int n, int[] queens){
        if(cur==n){
            totalQueens++;
            return;
        }
        for(int i=0;i<n;i++){
            queens[cur] = i;
            if(canQueen(queens,cur))
                DFS(cur+1,n,queens);
        }
    }
    public boolean canQueen(int[]queens, int pos){
        for(int i=0;i<pos;i++){
            if(queens[i]==queens[pos])
                return false;
            if(queens[i]+i==queens[pos]+pos)
                return false;
            if(queens[i]-i==queens[pos]-pos)
                return false;
        }
        return true;
    }
}
