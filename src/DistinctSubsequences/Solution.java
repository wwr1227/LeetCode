package DistinctSubsequences;

public class Solution {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (S == null || S.length() == 0)
			return 0;

		int[][] ans = new int[T.length() + 1][S.length() + 1];

		for (int j = 0; j <= T.length(); j++) {
			for (int i = 0; i <= S.length(); i++) {
				ans[j][i] = 0;
			}
		}
		for (int i = 0; i <= S.length(); i++) {
			ans[0][i] = 1;
		}
		for (int j = 1; j <= T.length(); j++) {
			for (int i = 1; i <= S.length(); i++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					ans[j][i] += (ans[j][i - 1] + ans[j - 1][i - 1]);
				} else {
					ans[j][i] += ans[j][i - 1];
				}
			}
		}
		return ans[T.length()][S.length()];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * ������Ҫʹ�ô������㡣ʹ��һ�� DP ���ɡ��ؼ�����εõ����ƹ�ϵ�����������룬��ĸ���ĳ���Ϊ j�� �Ӵ��ĳ���Ϊ i������Ҫ��ľ��ǳ���Ϊ i
 * ���ִ��ڳ���Ϊ j ��ĸ���г��ֵĴ�������Ϊ t[i][j]����ĸ�������һ���ַ����Ӵ������һ���ַ���ͬ���򳤶�Ϊ i ���Ӵ��ڳ���Ϊ j
 * ��ĸ���г��ֵĴ�������ĸ����ǰ j - 1 ���ַ����Ӵ����ֵĴ������� t[i][j] = t[i][j
 * -1]����ĸ�������һ���ַ����Ӵ������һ���ַ���ͬ����ô����ǰ j - 1 ���ַ������ִ��Ĵ����⣬��Ҫ�����Ӵ���ǰ i - 1 ���ַ���ĸ����ǰ j
 * - 1 ���ַ��г��ֵĴ������� t[i][j] = t[i][j - 1] + t[i - 1][j - 1]��
 * Ҳ�����ö�ά���飬����ͼʡ�£�ֱ���ù��������ˡ�
 */
