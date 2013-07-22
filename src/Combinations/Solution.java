package Combinations;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (n <= 0)
			return ans;

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
		}
		int kCount = 0;
		int kStart = 0;
		combination(array, item, ans, k, kCount, kStart);
		return ans;
	}

	public void combination(int[] array, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> ans, int k, int count, int start) {

		if (start > array.length)
			return;
		if (count == k) {
			ans.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i < array.length; ++i) {
			item.add(array[i]);
			count += 1;
			combination(array, item, ans, k, count, i + 1);
			count -= 1;
			item.remove(item.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		System.out.println(su.combine(4, 2));

	}

}
