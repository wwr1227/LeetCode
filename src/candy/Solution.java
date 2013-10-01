public class Solution {
   public int candy(int[] ratings) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (ratings == null || ratings.length == 0)
			return 0;

		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);

	    for (int i = 1; i < ratings.length; i++)
			if (ratings[i] > ratings[i - 1])
				candy[i] = candy[i - 1] + 1;

		for (int i = ratings.length - 1; i > 0; i--)
			if (ratings[i - 1] > ratings[i])
				candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);

		int count = 0;
		for (int i = 0; i < candy.length; i++)
			count += candy[i];

		return count;
	}
}
