/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
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
    	ArrayList<Interval> ans= new  ArrayList<Interval>();
		if(intervals==null||intervals.size()==0)
			return ans;
		Collections.sort(intervals, new IntervalComparator());
		ans.add(intervals.get(0));
		for(int i=1;i<intervals.size();i++){
			int start = ans.get(ans.size()-1).start;
			int end = ans.get(ans.size()-1).end;
			if(start<=intervals.get(i).end && end>=intervals.get(i).start){
				start = Math.min(start,intervals.get(i).start);
				end = Math.max(end,intervals.get(i).end);
                ans.remove(ans.size()-1);
				ans.add(new Interval(start,end));
			}else{
				ans.add(intervals.get(i));
			}
		}
        return ans;
    }
}
