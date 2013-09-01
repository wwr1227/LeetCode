//Time complexity:O(n)
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class ComparatorByBeginMinute implements Comparator<Interval> {
    @Override
	public int compare(Interval arg0, Interval arg1) {
		return arg0.start - arg1.start;
	}
}
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> ans = new ArrayList<Interval>();
        Collections.sort(intervals,new ComparatorByBeginMinute());
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        boolean isInsert = false;
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i).start<=newEnd && intervals.get(i).end>=newStart){
                newStart=Math.min(newStart,intervals.get(i).start);
                newEnd=Math.max(newEnd,intervals.get(i).end);
            }else{
                if(!isInsert&& newEnd<intervals.get(i).start){
                    isInsert=true;
                    ans.add(new Interval(newStart,newEnd));
                }
                ans.add(intervals.get(i));
            }
        }
        if(!isInsert){
            ans.add(new Interval(newStart,newEnd));
        }
        return ans;
    }
}
