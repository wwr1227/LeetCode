package EditDistance;

public class Solution {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (word1 == "")
			return word2.length();
		if (word2 == "")
			return word1.length();
		int[][] distance = new int[word1.length() + 1][word2.length() + 1];
		distance[0][0] = 0;
		for (int i = 1; i <= word1.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= word2.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int equal = 1;
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					equal = 0;
				}
				distance[i][j] = getMin(distance[i - 1][j] + 1,
						distance[i][j - 1] + 1, distance[i - 1][j - 1] + equal);
			}
		}

		return distance[word1.length()][word2.length()];
	}

	public int getMin(int a, int b, int c) {
		if (a < b) {
			if (a < c)
				return a;
			else
				return c;
		} else {
			if (b < c)
				return b;
			else
				return c;
		}
	}

	public static void main(String[] args) {
		Solution su = new Solution();
		String word1 = "a";
		String word2 = "b";
		// System.out.println(su.getMin(3, 2, 1));
		System.out.println(su.minDistance(word1, word2));
	}
}
