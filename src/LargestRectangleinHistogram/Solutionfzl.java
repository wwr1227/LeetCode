package LargestRectangleinHistogram;

public class Solutionfzl {

	public int largestRectangleArea(int[] height) {
		int ans = 0;
		if (height == null)
			return ans;

		int len = height.length;
		if (len == 0)
			return ans;

		int[] left = new int[len];
		int[] right = new int[len];

		for (int i = 0; i < len; i++) {
			left[i] = i - 1;
			while (left[i] != -1 && height[left[i]] >= height[i])
				left[i] = left[left[i]];
		}
		for (int j = len - 1; j >= 0; j--) {
			right[j] = j + 1;
			while (right[j] != len && height[right[j]] <= height[j])
				right[j] = right[right[j]];
		}

		for (int i = 0; i < len; i++) {
			ans = getMax(ans, height[i] * (right[i] - left[i] - 1));
		}
		return ans;
	}

	public int getMax(int a, int b) {
		return a > b ? a : b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] height = { 4, 2 };
		System.out.println(su.largestRectangleArea(height));
	}

}
