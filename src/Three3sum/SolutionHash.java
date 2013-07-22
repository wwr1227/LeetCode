package Three3sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SolutionHash {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return ans;

		int[] sortNum = quickSortImpl(num, 0, num.length - 1);
		int len = sortNum.length;

		ArrayList<Integer> item = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> fmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			map.put(i, sortNum[i]);
			fmap.put(i, sortNum[i]);
		}

		int target = 0;
		for (int i = 0; i < len; i++) {
			fmap.remove(i);
			int one = sortNum[i];
			int value1 = target - one;
			for (int j = 0; j < len; j++) {

				if (j != i) {
					fmap.remove(j);
					int two = sortNum[j];
					int value2 = value1 - two;
					if (fmap.containsValue(value2)) {
						item.add(one);
						item.add(two);
						item.add(value2);
						Collections.sort(item);
						ans.add(new ArrayList<Integer>(item));
						item.clear();
					}

					fmap.put(j, sortNum[j]);
				}
			}
			fmap.put(i, sortNum[i]);
		}
		return removeDuplicate(ans);

	}

	public ArrayList<ArrayList<Integer>> removeDuplicate(
			ArrayList<ArrayList<Integer>> arlList) {
		HashSet<ArrayList<Integer>> h = new HashSet<ArrayList<Integer>>(arlList);
		arlList.clear();
		arlList.addAll(h);
		return arlList;
	}

	public int[] quickSortImpl(int[] nums, int left, int right) {
		int l = left;
		int r = right;

		while (left < right) {

			int temp = nums[left];
			while (temp <= nums[right] && right > left) {
				right--;
			}
			nums[left] = nums[right];

			while (temp >= nums[left] && right > left) {
				left++;
			}
			nums[right] = nums[left];
			nums[left] = temp;
			quickSortImpl(nums, l, left - 1);
			quickSortImpl(nums, left + 1, r);
		}
		return nums;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] test = { 1, 2, -2, -1 };
		ArrayList<ArrayList<Integer>> ans = new SolutionHash().threeSum(test);

		System.out.println(ans);

	}

}
