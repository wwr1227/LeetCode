package NextPermutation;

public class Solution {
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (num == null)
			return;
		int len = num.length;
		if (len == 0 || len == 1)
			return;
		int swaper = 0;
		boolean flag = true;
		for (int i = len - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				swaper = i - 1;
				flag = false;
				break;
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			if (num[i] > num[swaper]) {
				int temp = num[i];
				num[i] = num[swaper];
				num[swaper] = temp;
				break;
			}
		}

		if (flag)
			num = reverse(num, swaper);
		else
			num = reverse(num, swaper + 1);

	}

	public int[] reverse(int[] num, int start) {
		int length = num.length - start;
		int len = num.length;
		int index = 0;
		for (int i = start; i < start + length / 2; i++) {
			int temp = num[i];
			num[i] = num[len - 1 - index];
			num[len - 1 - index] = temp;
			index++;
		}

		return num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] num = { 3, 2, 1 };
		su.nextPermutation(num);

	}
}
