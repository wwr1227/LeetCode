package N_Queens;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> ans = new ArrayList<String[]>();
		if (n == 0)
			return ans;
		int[] pos = new int[n];
		DFS(0, n, pos, ans);
		return ans;
	}

	public void DFS(int x, int n, int[] pos, ArrayList<String[]> ans) {
		if (x == n) {
			StringBuffer[] item = new StringBuffer[n];
			String[] nQueen = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuffer tmpString = new StringBuffer("");
				for (int j = 0; j < n; j++) {
					tmpString.append('.');
				}
				item[i] = tmpString;
			}
			for (int i = 0; i < n; i++) {
				item[i].setCharAt(pos[i], 'Q');
				nQueen[i] = item[i].toString();
			}
			ans.add(nQueen);
			return;
		}
		for (int i = 0; i < n; i++) {
			pos[x] = i;
			if (legal(x, pos))
				DFS(x + 1, n, pos, ans);
		}

	}

	boolean legal(int x, int[] pos) {
		for (int j = 0; j < x; j++) {
			if (pos[j] == pos[x])
				return false;
			if (pos[j] - j == pos[x] - x)
				return false;
			if (j + pos[j] == x + pos[x])
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		System.out.println(su.solveNQueens(4));
	}

}
/*
 * [["Q"]] [["Q"]]
 * 
 * 2 [] []
 * 
 * 3 [] []
 * 
 * 4
 * [[".","Q",".",".",".",".",".","Q","Q",".",".",".",".",".","Q","."],[".",".",
 * "Q",".","Q",".",".",".",".",".",".","Q",".","Q",".","."]]
 * [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 
 * 8 [["Q",".",".",
 */