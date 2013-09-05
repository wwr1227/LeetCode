//O(n)
// 1, 11, 21, 1211, 111221, .
public String countAndSay(int n) {
		if (n < 1)
			return "";

		int i = 1;
		StringBuffer pre = new StringBuffer("1");
		StringBuffer cur = new StringBuffer();
		while (i < n) {
			cur.delete(0, cur.length());
			for (int j = 0; j < pre.length(); j++) {
				int count = 1;
				char say = pre.charAt(j);
				while (j < pre.length() - 1 && say == pre.charAt(j + 1)) {
					j++;
					count++;
				}
				cur.append(count);
				cur.append(say);

			}
			pre.delete(0, pre.length());
			pre.append(new StringBuffer(cur));
			i++;

		}
		return cur.toString();
}
