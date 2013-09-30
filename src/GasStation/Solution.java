/**
	 * There are N gas stations along a circular route, where the amount of gas
	 * at station i is gas[i].
	 * 
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
	 * travel from station i to its next station (i+1). You begin the journey
	 * with an empty tank at one of the gas stations.
	 * 
	 * Return the starting gas station's index if you can travel around the
	 * circuit once, otherwise return -1.
	 * 
	 * Note: The solution is guaranteed to be unique.
	 */
//O(n)
public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused
			if (gas == null || cost == null || gas.length == 0
					|| gas.length != cost.length)
				return -1;
			int n = gas.length;
			int start = -1;
			int tempSum = 0;
			int totalSum = 0;
			for (int i = 0; i < n; i++) {
				tempSum += gas[i] - cost[i];
				if (tempSum < 0) {
					tempSum = 0;
					start = i;
				}
				totalSum += gas[i] - cost[i];
			}
			return totalSum >= 0 ? start + 1 : -1;
	}
