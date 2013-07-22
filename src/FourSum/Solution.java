package FourSum;

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
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<TwoSum> ts = new ArrayList<TwoSum>();
		if (num == null || num.length < 4)
			return ans;

		Arrays.sort(num);
		int len = num.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				ts.add(new TwoSum(i, j, num[i] + num[j]));
			}
		}

		Collections.sort(ts, new FourSumComparator());
		// for (int i = 0; i < ts.size(); i++) {
		// System.out.println(ts.get(i).total);
		// }
		for (int i = 0; i < ts.size(); i++) {
			int val = target - ts.get(i).total;
			int beginIndex = binarySearchBegin(ts, i + 1, ts.size() - 1, val);
			int endIndex = binarySearchEnd(ts, i + 1, ts.size() - 1, val);
			for (int j = beginIndex; j <= endIndex; j++) {
				if (ts.get(j).oneNum == ts.get(i).oneNum)
					continue;
				if (ts.get(j).oneNum == ts.get(i).twoNum)
					continue;
				if (ts.get(j).twoNum == ts.get(i).oneNum)
					continue;
				if (ts.get(j).twoNum == ts.get(i).twoNum)
					continue;

				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[ts.get(i).oneNum]);
				item.add(num[ts.get(i).twoNum]);
				item.add(num[ts.get(j).oneNum]);
				item.add(num[ts.get(j).twoNum]);
				Collections.sort(item);
				if (!ans.contains(item))
					ans.add(item);
			}
		}
		return ans;
	}

	public int binarySearchBegin(ArrayList<TwoSum> ts, int start, int end,
			int value) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ts.get(mid).total >= value)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return end + 1;
	}

	public int binarySearchEnd(ArrayList<TwoSum> ts, int start, int end,
			int value) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ts.get(mid).total <= value)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start - 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] num = { -3, 0, 7, -2, -6, -5, 1, 5, -1, -8, -9, -8, 7, 1, 1, 3,
				1, 10 };
		int target = 0;
		System.out.println(su.fourSum(num, target));

	}

}
