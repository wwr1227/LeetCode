package LargestRectangleinHistogram;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public int largestRectangleArea(int[] height) {
		int n = height.length;
		if (n == 0)
			return 0;

		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();

		int[] width = new int[n];// widths of intervals.
		Arrays.fill(width, 1);// all intervals should at least be 1 unit wide.

		for (int i = 0; i < n; i++) {
			// count # of consecutive higher bars on the left of the (i+1)th bar
			while (!left.isEmpty() && height[i] <= height[left.peek()]) {
				// while there are bars stored in the stack, we check the bar on
				// the top of the stack.
				left.pop();
			}

			if (left.isEmpty()) {
				// all elements on the left are larger than height[i].
				width[i] += i;
			} else {
				// bar[left.peek()] is the closest shorter bar.
				width[i] += i - left.peek() - 1;
			}
			left.push(i);
		}

		for (int i = n - 1; i >= 0; i--) {

			while (!right.isEmpty() && height[i] <= height[right.peek()]) {
				right.pop();
			}

			if (right.isEmpty()) {
				// all elements to the right are larger than height[i]
				width[i] += n - 1 - i;
			} else {
				width[i] += right.peek() - i - 1;
			}
			right.push(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			// find the maximum value of all rectangle areas.
			max = Math.max(max, width[i] * height[i]);
		}
		return max;
		// Start typing your Java solution below
		// // DO NOT write main() function
		// Stack<Integer> S = new Stack<Integer>();
		//
		// int sum = 0;
		// for (int i = 0; i < height.length; i++) {
		// if (S.empty() || height[i] > height[S.peek()])
		// S.push(i);
		// else {
		// int tmp = S.peek();
		// S.pop();
		// sum = Math.max(sum, height[tmp]
		// * (S.empty() ? i : i - S.peek() - 1));
		// i--;
		// }
		// }
		// return sum;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * public int largestRectangleArea(int[] height) { // Start typing your Java
 * solution below // DO NOT write main() function int ans=0; if(height==null)
 * return ans;
 * 
 * int len = height.length; if(len==0) return ans;
 * 
 * int []left = new int[len]; int []right= new int[len];
 * 
 * for(int i=0;i<len;i++){ left[i]=i-1; while(left[i]!=-1 &&
 * height[left[i]]>=height[i]) left[i]=left[left[i]]; } for(int j=len-1;
 * j>=0;j--){ right[j]=j+1; while(right[j]!=len&&height[right[j]]<=height[j])
 * right[j]=right[right[j]]; }
 * 
 * for(int i=0;i<len;i++){ ans = Math.max(ans, height[i]*(right[i]-left[i]-1));
 * } return ans; }
 */
