//O(n^2)
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> ans = new  ArrayList<String[]>();
        int[] queens= new int[n];
        if(n<=0)
            return ans;
        DFS(0,n,ans,queens);
        return ans;
    }
    public void DFS(int cur, int n, ArrayList<String[]> ans , int[] queens){
        if(cur==n){
            char[][] rows = new char[n][n];
            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++)
                    if(i==queens[j])
                        rows[j][i]='Q';
                    else
                        rows[j][i]='.';
            }
            String[] ansStr=new String[n];
            for(int i=0;i<n;i++){
                ansStr[i]= String.valueOf(rows[i]);
            }
            ans.add(ansStr);
            return;
        }
        for(int i=0;i<n;i++){
            queens[cur] = i;
            if(canQueen(queens,cur))
                DFS(cur+1,n,ans,queens);
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
