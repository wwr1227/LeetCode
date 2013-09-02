//O(n^2)
public class Solution {
    	public int minCut(String s) {
    		int ans = 0;
		if (s == null || s.length() == 0)
			return ans;
		boolean[][] isPa = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--)
			for (int j = i; j < s.length(); j++)
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || isPa[i + 1][j - 1]))
					isPa[i][j] = true;
		int[] paLen = new int[s.length()];
		for (int i = 0; i < s.length(); i++)
			paLen[i] = Integer.MAX_VALUE;
		paLen[0]=0;
		for (int i = 0; i < s.length(); i++){
			for (int j = 0; j < i; j++){
				if (isPa[0][i])
					paLen[i] = 0;
				if (isPa[j+1][i])
					paLen[i] = Math.min(paLen[i], paLen[j] + 1);
			}
		}
		return paLen[s.length()-1];

	}
}
