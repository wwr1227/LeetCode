//O(A(n,n))
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return ans;
		Arrays.sort(num);
		permuteHandler(num, ans, 0);
		return ans;
	}

	public void permuteHandler(int[] num, ArrayList<ArrayList<Integer>> ans,
			int k) {
		if (k == num.length) {
			ArrayList<Integer> item = new ArrayList<Integer>(num.length);
			for (int i = 0; i < num.length; i++)
				item.add(Integer.valueOf(num[i]));
			if (!ans.contains(item))
				ans.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = k; i < num.length; i++) {
			if (isSwap(num, k, i)) {
				swap(num, k, i);
				permuteHandler(num, ans, k + 1);
				swap(num, k, i);
			}
		}
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public boolean isSwap(int[] arr, int i, int j) {
		for (int k = i; k < j; k++) {
			if (arr[k] == arr[j]) {
				return false;
			}
		}
		return true;
	}
}
