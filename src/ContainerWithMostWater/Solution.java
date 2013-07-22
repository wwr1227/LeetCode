package ContainerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;

		int start = 0, end = len - 1;
		int ans = 0, area = 0;
		while (start < end) {
			if (height[start] > height[end]) {
				area = (end - start) * height[end];
				end--;
			} else {
				area = (end - start) * height[start];
				start++;
			}
			if (area > ans)
				ans = area;
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
