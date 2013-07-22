package Permutations;

import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (num == null || num.length == 0)
			return ans;

		permuteHelper(ans, item, num, 0, num.length);

		return ans;
	}

	public void permuteHelper(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> item, int[] num, int left, int right) {
		if (left == right) {
			for (int i = 0; i < num.length; i++) {
				item.add(num[i]);
			}
			ans.add(new ArrayList<Integer>(item));
			item.clear();
			return;
		}

		for (int i = left; i < right; i++) {
			swap(num, left, i);
			permuteHelper(ans, item, num, left + 1, right);
			swap(num, i, left);
		}
	}

	public void swap(int[] num, int left, int right) {
		if (left == right)
			return;

		int temp = num[left];
		num[left] = num[right];
		num[right] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] num = { 1, 2, 3 };
		System.out.println(su.permute(num));
	}

}
