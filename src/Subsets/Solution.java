package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cset = new ArrayList<Integer>();
		subsets(S, 0, res, cset);
		return res;

	}

	public void subsets(int[] S, int off, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> cset) {
		if (off == S.length) {
			res.add(new ArrayList<Integer>(cset)); // When add one subset to the
													// result set, we can't just
													// say "res.add(cset)"
													// because
			return; // cset is just a pointer to the ArrayList object(the
					// program would modify cset later on).
		} // So we have to invode the copy constructor instead.
		cset.add(S[off]);
		subsets(S, off + 1, res, cset);
		cset.remove(cset.size() - 1); // Very important--restore the global
										// invariant for next recursive calls.
		subsets(S, off + 1, res, cset);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
