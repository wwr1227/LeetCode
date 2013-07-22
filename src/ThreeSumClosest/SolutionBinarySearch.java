package ThreeSumClosest;

import java.util.Arrays;

public class SolutionBinarySearch {
	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length == 0)
			return 0;
		int len = num.length;

		Arrays.sort(num);
		int res = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len - 2; i++) {

			for (int j = i + 1; j < len - 1; j++) {

				int val = num[i] + num[j];
				int best = binarySearch(num, j + 1, len - 1, (target - val));

				if (min > Math.abs(target - val - best)) {
					min = Math.abs(target - val - best);
					res = val + best;
				}
			}
		}
		return res;
	}

	public int binarySearch(int[] num, int start, int end, int remain) {
		int min = Integer.MAX_VALUE;
		int best = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (num[mid] == remain)
				return num[mid];
			else if (num[mid] > remain)
				end = mid - 1;
			else if (num[mid] < remain)
				start = mid + 1;

			if (min > Math.abs(num[mid] - remain)) {
				min = Math.abs(num[mid] - remain);
				best = num[mid];
			}
		}
		return best;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionBinarySearch su = new SolutionBinarySearch();
		int[] num = { 25, -12, 2, 66, -8, 67, 67, -93, -97, -68, -49, -24, 49,
				90, 31, 87, -1, 14, 50, -25, 69, -91, -23, 82, -43, 96, 80, 43,
				4, -87, 40, 24, -71, -10, -16, 78, -60, -20, -84, 69, 84, 84,
				16, -23, -25, 88, 15, 72, -82, -72, -16, 49, 50, 26, 3, 26,
				-92, 82, -69, 60, -81, 24, -25, -47, -77, -37, -33, 69, 21,
				-50, 56, -43, 18, -87, 96, 47, 59, 37, 100, 23, -34, -69, -12,
				-83, -65, 91, 75, 100, 24, 80, 64, -27, -31, 39, -46, -73, 88,
				-13, -10, 67, 95, 27, 91, -61, -44, 67, 0, -29, -57, -61, -62,
				83, -6, 82, -58, -58, -5, -87, -44, 9, -20, -28, 3, 17, 57,
				-63, 78, 34, 7, -68, 30, -49, 77, -97, 15, -42, -49, -22, -60,
				78, 84, 35, 19 };
		int target = 250;
		System.out.println(su.threeSumClosest(num, target));
	}
	/**
	 * [25,-12,2,66,-8,67,67,-93,-97,-68,-49,-24,49,90,31,87,-1,14,50,-25,69,-91
	 * ,-23,82,-43,96,80,43,4,-87,40,24,-71,-10,-16,78,-60,-20,-84,69,84,84,16,-
	 * 23 ,-25,88,15,72,-82,-72,-16,49,50,26,3,26,-92,82,-69,60,-81,24,-25,-47,-
	 * 77 ,-
	 * 37,-33,69,21,-50,56,-43,18,-87,96,47,59,37,100,23,-34,-69,-12,-83,-65,91
	 * ,75
	 * ,100,24,80,64,-27,-31,39,-46,-73,88,-13,-10,67,95,27,91,-61,-44,67,0,-29
	 * ,- 57,-61,-62,83,-6,82,-58,-58,-5,-87,-44,9,-20,-28,3,17,57,-63,78,34,7,-
	 * 68 ,30,-49,77,-97,15,-42,-49,-22,-60,78,84,35,19], 250
	 */
}
