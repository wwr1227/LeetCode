package MergeIntervals;

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

class IntervalComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		Interval interval0 = (Interval) arg0;
		Interval interval1 = (Interval) arg1;
		return interval0.start - interval1.start;
	}
}

public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (intervals.size() < 1)
			return intervals;
		Collections.sort(intervals, new IntervalComparator());
		Stack<Interval> stack = new Stack<Interval>();

		for (int i = 0; i < intervals.size(); i++) {
			if (stack.isEmpty())
				stack.push(intervals.get(i));
			Interval temp = stack.pop();
			if (temp.end >= intervals.get(i).start) {
				if (temp.end >= intervals.get(i).end)
					stack.push(temp);
				else
					stack.push(new Interval(temp.start, intervals.get(i).end));
			} else {
				stack.push(temp);
				stack.push(intervals.get(i));
			}
		}
		ArrayList<Interval> ans = new ArrayList<Interval>(0);
		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		Collections.sort(intervals, new IntervalComparator());
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		ArrayList<Interval> intervals = new ArrayList<Interval>(0);
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		ArrayList<Interval> ans = su.merge(intervals);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i).start + " " + ans.get(i).end);
		}
	}

}
