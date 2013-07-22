package InsertInterva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<Interval> ans = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			ans.add(newInterval);
			return ans;
		}
		Collections.sort(intervals, new ComparatorByBeginMinute());

		Stack<Interval> stack = new Stack<Interval>();
		stack.push(newInterval);
		for (Interval in : intervals) {
			Interval curInterval = stack.pop();
			if (in.end < curInterval.start) {
				stack.push(in);
			} else {
				curInterval = new Interval(
						Math.min(in.start, curInterval.start), Math.max(in.end,
								curInterval.end));
			}
			stack.push(curInterval);
		}
		int i = 0;
		while (!stack.isEmpty()) {
			Interval insert = stack.pop();
			ans.add(i, insert);
			i++;
		}
		Collections.sort(ans, new ComparatorByBeginMinute());
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution su = new Solution();
		Interval in1 = new Interval(1, 5);
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(in1);
		Interval newIn = new Interval(6, 8);
		System.out.println(su.insert(list, newIn));
	}

}

class ComparatorByBeginMinute implements Comparator<Interval> {

	@Override
	public int compare(Interval arg0, Interval arg1) {
		return arg0.start - arg1.start;
	}
}
