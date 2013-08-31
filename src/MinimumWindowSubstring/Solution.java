package MinWindow;

public class MinWindow {
	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function

		String ans = "";
		if (S == null)
			return ans;

		int slen = S.length();
		int tlen = T.length();

		if (tlen > slen)
			return ans;

		int anslen = slen + 1;
		int needFound[] = new int[256];
		int alreadyFound[] = new int[256];
		for (int i = 0; i < 256; i++) {
			needFound[i] = 0;
			alreadyFound[i] = 0;
		}
		for (int i = 0; i < tlen; i++) {
			needFound[T.charAt(i)]++;
		}

		int index = 0;
		int temp = 0;

		int next = 0;
		for (int prev = 0; prev < slen; prev++) {
			if (needFound[S.charAt(prev)] > 0) {
				alreadyFound[S.charAt(prev)]++;
				if (alreadyFound[S.charAt(prev)] <= needFound[S.charAt(prev)]) {
					index++;
				}
			}
			if (index == tlen) {
				while (needFound[S.charAt(next)] == 0
						|| alreadyFound[S.charAt(next)] > needFound[S
								.charAt(next)]) {
					if (alreadyFound[S.charAt(next)] > needFound[S.charAt(next)])
						alreadyFound[S.charAt(next)]--;
					next++;
					if (next > slen)
						break;
				}

				System.out.println("got: " + next + " " + prev);
				temp = prev - next + 1;
				if (temp < anslen) {
					anslen = temp;
					ans = S.substring(next, prev + 1);
					System.out.println("got: " + next + " " + prev + " " + ans);
				}
			}
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(new MinWindow().minWindow(s, t));
	}

}
