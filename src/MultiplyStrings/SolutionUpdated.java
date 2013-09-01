//Time complexity:O(n^2)
public class Solution {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0
				|| num2.length() == 0)
			return "0";

		num1 = reverseString(num1);
		num2 = reverseString(num2);
		int[] multi = new int[num1.length() + num2.length()];
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				int sum = Character.getNumericValue(num1.charAt(i))
						* Character.getNumericValue(num2.charAt(j));
				multi[i + j] += sum;
			}
		}
		
		int carry = 0;
		for (int i = 0; i < multi.length; i++) {
			int sum = multi[i] + carry;
			multi[i] = sum % 10;
			carry = sum / 10;
		}
		reverseArray(multi);
	
		String ans = "";
		int start = 0;
		while (start < multi.length && multi[start] == 0)
			start++;
		for (int i = start; i < multi.length; i++)
			ans += multi[i];
		if (ans.length() == 0)
			return "0";
		else
			return ans;
	}

	public String reverseString(String str) {
		if (str == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--)
			sb.append(str.charAt(i));
		return sb.toString();
	}

	public int[] reverseArray(int[] array) {
		if (array == null)
			return array;
		for (int i = 0; i < array.length / 2; i++) {
			swap(array, i, array.length - 1 - i);
		}
		return array;
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
