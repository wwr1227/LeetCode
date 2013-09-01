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
		getSum(candidates, target, ans, item, 0);
		return ans;
	}

	public void getSum(int[] candidates, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> item, int start) {
		if (target == 0) {
			ans.add(new ArrayList<Integer>(item));
			item.clear();
			return;
		}
		if (target < 0)
			return;
		for (int i = start; i < candidates.length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(item);
			temp.add(candidates[i]);
			getSum(candidates, target - candidates[i], ans, temp, i);
		}
	}

}
