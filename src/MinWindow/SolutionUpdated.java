public class Solution {
    public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int slen = S.length();
		int tlen = T.length();
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];
		int minWindow = Integer.MAX_VALUE;
		int minWindowBegin = -1;
		int count = 0;
		for (int i = 0; i < tlen; i++)
			needToFind[T.charAt(i)]++;
		for (int begin = 0, end = 0; end < slen; end++) {
			if (needToFind[S.charAt(end)] == 0)
				continue;
			hasFound[S.charAt(end)]++;
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
				count++;
			if (count >= tlen) {
				while (needToFind[S.charAt(begin)] == 0
						|| hasFound[S.charAt(begin)] > needToFind[S
								.charAt(begin)]) {
					if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;

				}
				int windowLen = end - begin + 1;
				if (windowLen < minWindow) {
					minWindowBegin = begin;
					minWindow = windowLen;
				}
			}
		}
        if(minWindowBegin==-1)
            return "";
        else
		    return S.substring(minWindowBegin, minWindowBegin + minWindow);
	}
}
