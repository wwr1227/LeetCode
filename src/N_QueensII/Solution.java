package N_QueensII;

public class Solution {
	int count = 0;
	int allQueen;

	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		count = 0;
		allQueen = (1 << n) - 1;
		cal(0, 0, 0);
		return count;
	}

	public void cal(int row, int l, int r) {
		if (row == allQueen) {
			count++;
		} else {
			int curQueen;
			curQueen = allQueen & (~(row | l | r));
			while (curQueen != 0) {
				int newQueen = curQueen & (-curQueen);
				curQueen = curQueen - newQueen;
				cal(row + newQueen, (l + newQueen) << 1, (r + newQueen) >> 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
