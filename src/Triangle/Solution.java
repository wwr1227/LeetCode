package Triangle;

import java.util.ArrayList;

public class Solution {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int rows = triangle.size();
		int cols = triangle.get(rows - 1).size();

		int[][] ans = new int[rows + 1][cols + 1];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= triangle.get(i).size(); j++) {
				ans[i][j] = 0;
			}
		}

		for (int j = 0; j < triangle.get(rows - 1).size(); j++) {
			ans[rows][j] = 0;
		}

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				int num = triangle.get(i).get(j);
				ans[i][j] = getMin(ans[i + 1][j] + num, ans[i + 1][j + 1] + num);
			}
		}
		return ans[0][0];

	}

	public int getMin(int a, int b) {
		return a > b ? b : a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>(
				0);
		ArrayList<Integer> row = new ArrayList<Integer>(0);
		row.add(2);
		triangle.add(row);
		row = new ArrayList<Integer>(0);
		row.add(3);
		row.add(4);
		triangle.add(row);
		row = new ArrayList<Integer>(0);
		row.add(5);
		row.add(6);
		row.add(7);
		triangle.add(row);
		row = new ArrayList<Integer>(0);
		row.add(4);
		row.add(1);
		row.add(8);
		row.add(3);
		triangle.add(row);
		System.out.println(su.minimumTotal(triangle));

	}
}
