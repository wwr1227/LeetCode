package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ansDup = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (num == null || num.length == 0)
			return ans;
		Arrays.sort(num);
		int index = 0;
		subsetsHelper(num, ans, item, index);
		for (ArrayList<Integer> s : ans) {
			if (Collections.frequency(ansDup, s) < 1)
				ansDup.add(s);
		}
		return ansDup;
	}

	public void subsetsHelper(int[] num, ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> item, int index) {

		if (num.length == index) {
			ans.add(new ArrayList<Integer>(item));
			return;
		}
		item.add(num[index]);
		subsetsHelper(num, ans, item, index + 1);
		item.remove(item.size() - 1);
		subsetsHelper(num, ans, item, index + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] num = { 1, 2, 2 };
		System.out.println(su.subsetsWithDup(num));
	}

}
