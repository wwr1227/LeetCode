package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0)
			return ans;
		Arrays.sort(candidates);
		ArrayList<Integer> item = new ArrayList<Integer>();
		combinationHelper(candidates, target, 0, 0, item, ans);

		return removeDup(ans);
	}

	public ArrayList<ArrayList<Integer>> removeDup(
			ArrayList<ArrayList<Integer>> ori) {
		HashSet hs = new HashSet(ori);
		ori.clear();
		ori.addAll(hs);
		return ori;

	}

	public void combinationHelper(int[] candidates, int target, int sum,
			int index, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> ans) {

		if (sum > target) {
			return;
		}

		if (sum == target) {
			ArrayList<Integer> res = new ArrayList<Integer>(item);
			Collections.sort(res);
			ans.add(new ArrayList<Integer>(res));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			sum += candidates[i];
			item.add(candidates[i]);
			combinationHelper(candidates, target, sum, ++index, item, ans);
			item.remove(item.size() - 1);
			sum -= candidates[i];
		}

	}
}
