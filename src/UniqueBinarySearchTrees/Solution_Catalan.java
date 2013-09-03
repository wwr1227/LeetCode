//O(n)
public class Solution {
		public int numTrees(int n) {
			  int c = 1;
			  for (int i = 2; i <= n; i++)
				  c = 2 * (2 * i - 1) * c / (i + 1);
			  return c;
		}
}
