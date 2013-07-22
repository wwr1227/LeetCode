package Three3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return ans;
		ArrayList<Integer> item = new ArrayList<Integer>();
//		int[] sortNum = quickSortImpl(num, 0, num.length - 1);
		int[] sortNum = num;
		Arrays.sort(sortNum); 
		int target = 0;
		int len = sortNum.length;

		for (int i = 0; i < len-1; i++) {
			int one = sortNum[i];
			int m = i+1;
			int n = len - 1;
			while (m < n) {
				// System.out.println(target);
				// System.out.println(one + " " + sortNum[m] + " " +
				// sortNum[n]);
				if (sortNum[m] + sortNum[n] + one == target) {
					item.add(one);
					item.add(sortNum[m]);
					item.add(sortNum[n]);
					Collections.sort(item);
					ans.add(new ArrayList<Integer>(item));
					item.clear();
					m++;
					n--;
				} else if (sortNum[m] + sortNum[n] + one < target) {
					m++;
				} else {
					n--;
				}
			}
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

		int[] test = { 0, 1, -1 };
		ArrayList<ArrayList<Integer>> ans = new Solution().threeSum(test);

		System.out.println(ans);

	}

}
