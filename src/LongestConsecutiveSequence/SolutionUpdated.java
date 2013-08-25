public class Solution {
    public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num == null || num.length == 0)
			return 0;
		Queue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < num.length; i++) {
			priorityQueue.offer(num[i]);
		}
		int temp = priorityQueue.poll();
		int count = 1;
		int longestCount = 1;
		while (!priorityQueue.isEmpty()) {
			int cur = priorityQueue.poll();
            if(temp==cur){
                continue;
            }else if (temp + 1 == cur) {
				count++;
				temp++;
			} else {
				count = 1;
				temp = cur;
			}
			longestCount = Math.max(longestCount, count);
		}
		return longestCount;
	}
}
