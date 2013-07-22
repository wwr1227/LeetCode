package MultiplyStrings;

public class Solution {
	public String multiply(String num1, String num2) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if (num1.length() == 0 || num2.length() == 0)
			return "0";
		StringBuilder res = new StringBuilder("");
		for (int i = 0; i <= num1.length() + num2.length() + 1; i++)
			res.append("0");
		num1 = reverse(num1);
		num2 = reverse(num2);
		for (int i = 0; i < num1.length(); i++) {
			int dig1 = num1.charAt(i) - '0';
			int carry = 0;
			for (int j = 0; j < num2.length(); j++) {
				int dig2 = num2.charAt(j) - '0';
				int exist = res.charAt(i + j) - '0';
				char value = Character.forDigit(
						(dig1 * dig2 + carry + exist) % 10, 10);
				res.setCharAt(i + j, value);
				carry = (dig1 * dig2 + carry + exist) / 10;
			}
			if (carry > 0) {
				res.setCharAt(i + num2.length(), Character.forDigit(carry, 10));
			}
		}
		res = new StringBuilder(reverse(res.toString()));
		int start = 0;
		while (start < res.length() && res.charAt(start) == '0') {
			start++;
		}
		if (start == res.length())
			return "0";
		return res.toString().substring(start, res.length());
	}

	public String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String num1 = "0";
		String num2 = "0";
		System.out.println(su.multiply(num1, num2));
	}

}
