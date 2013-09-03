//O(n)
//http://www.matrix67.com/blog/archives/266
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
	//row、ld和rd，分别表示在纵列和两个对角线方向的限制条件下这一行的哪些地方不能放
	public void cal(int row, int l, int r) {
		if (row == allQueen) {
			count++;
		} else {
			int curQueen;
			curQueen = allQueen & (~(row | l | r));//得到所有可以放的位置
			while (curQueen != 0) {
				int newQueen = curQueen & (-curQueen);//-a相当于not a + 1，其结果是取出最右边的那个1
				curQueen = curQueen - newQueen;
				cal(row + newQueen, (l + newQueen) << 1, (r + newQueen) >> 1);
			}
		}
	}
}
