package JumpGame;

import java.util.ArrayList;

public class Solution {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length < 1)
			return false;
		if (A.length == 1)
			return true;
		for (int i = 0; i < A.length - 1; i++) {
			int newPos = A[i];
			if (A[i] == 0)
				return false;
			if (newPos > A.length - 1)
				return false;
			if (newPos == A.length - 1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		int[] a = { 3, 2, 1, 0, 4 };
		System.out.println(su.canJump(a));

	}
}
