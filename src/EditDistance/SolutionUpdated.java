public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = word1.length();
    	int len2 = word2.length();
        if(len1==0)
            return len2;
        if(len2==0)
            return len1;
		int[][] distance = new int[len1+1][len2+1];
		for(int i=0;i<=len1;i++)
			distance[i][0]=i;
		for(int i=0;i<=len2;i++)
			distance[0][i]=i;
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++)
				if(word1.charAt(i-1)==word2.charAt(j-1))
					distance[i][j]=distance[i-1][j-1];
				else
					distance[i][j]=Math.min(distance[i-1][j-1], Math.min(distance[i][j-1],distance[i-1][j]))+1;
		}
		return distance[len1][len2];
    }
}
