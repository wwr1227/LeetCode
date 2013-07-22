package ThreeSumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class TwoSum {
	int oneNum;
	int twoNum;
	int total;

	TwoSum(int oneNum, int twoNum, int total) {
		this.oneNum = oneNum;
		this.twoNum = twoNum;
		this.total = total;
	}
}

class FourSumComparator implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		TwoSum p1 = (TwoSum) o1;
		TwoSum p2 = (TwoSum) o2;
		if (p1.total == p2.total) {
			if (p1.oneNum == p2.oneNum)
				return p1.twoNum - p2.twoNum;
			else
				return p1.oneNum - p2.oneNum;
		} else
			return p1.total - p2.total;
	}
}

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		ArrayList<TwoSum> ts = new ArrayList<TwoSum>();
		if (num == null || num.length < 3)
			return 0;

		Arrays.sort(num);
		int len = num.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				ts.add(new TwoSum(i, j, num[i] + num[j]));
			}
		}

		Collections.sort(ts, new FourSumComparator());
		int compare = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < ts.size(); i++) {
			int val = ts.get(i).total;
			for (int j = 0; j < len && j != ts.get(i).oneNum
					&& j != ts.get(i).twoNum; j++) {
				if (num[j] + val == target)
					return target;
				if (Math.abs(val + num[j] - target) < compare) {
					compare = Math.abs(val + num[j] - target);
					result = val + num[j];
				}
			}
		}
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
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
