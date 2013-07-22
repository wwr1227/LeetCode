package TwoSum;

public class Solution2 {
	public int[] twoSum(int[] numbers, int target) {
		System.out.println(target);
		int[] ans = { 0, 0 };
		int left = 0;
		int right = numbers.length - 1;
		System.out.println(left + " " + right);
		while (left < right) {
			System.out.println(numbers[left] + " " + numbers[right] + " "
					+ numbers[left] + numbers[right]);
			if (numbers[left] + numbers[right] == target) {
				ans[0] = left + 1;
				ans[1] = right + 1;
				break;
			} else if (numbers[left] + numbers[right] > target) {
				right--;
				// int[] temp = getArray(numbers, left, right);
				// return traverse(left, right, temp, target);
			} else {
				left++;
				// int[] temp = getArray(numbers, left, right);
				// return traverse(left, right, temp, target);
			}
		}
		return ans;
	}

	// public int[] traverse(int left, int right, int[] numbers, int target) {
	// int[] ans = { 0, 0 };
	//
	// if (left < right) {
	// if (numbers[left] + numbers[right] == target) {
	// ans[0] = left;
	// ans[1] = right;
	// return ans;
	// } else if (numbers[left] + numbers[right] > target) {
	// right--;
	// int[] temp = getArray(numbers, left, right);
	// return traverse(left, right, temp, target);
	// } else {
	// left++;
	// int[] temp = getArray(numbers, left, right);
	// return traverse(left, right, temp, target);
	// }
	// } else {
	// return ans;
	// }
	// }

	public static void main(String[] args) {
		System.out.println("0");
		Solution su = new Solution();
		int[] numbers = { 150, 24, 79, 50, 88, 345, 3 };
		int target = 200;
		int[] ans = su.twoSum(numbers, target);
//		for (int i = 0; i < 2; i++)
//			System.out.print(ans[i] + " ");
	}
}
