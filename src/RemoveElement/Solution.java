package RemoveElement;

public class Solution {
	public int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return 0;
		int len = A.length;
		if (len == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (A[i] != elem) {
				A[count++] = A[i];
			}
		}
		return count;
	}

}