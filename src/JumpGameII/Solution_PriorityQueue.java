public class Solution_PriorityQueue {
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (A == null||A.length==0) return 0;
		int len = A.length;
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(0);
		for (int i = 0; i < len; i++) {
			if (i + A[i] > pq.peek())
				pq.offer(i + A[i]);
		}
		int[] ans = new int[len];
		ans[0] = 0;
		for (int i = 1; i < len; i++) {
			while (!pq.isEmpty() && pq.peek() + A[pq.peek()] < i) {
				pq.poll();
			}
			if (pq.isEmpty())
				return 0;
			ans[i] = ans[pq.peek()] + 1;
		}
		return ans[len - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 1, 1, 4 };
		Solution_PriorityQueue su = new Solution_PriorityQueue();
		System.out.println(su.jump(A));
	}

}
