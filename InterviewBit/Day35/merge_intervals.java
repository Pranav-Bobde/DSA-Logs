//Link: https://www.interviewbit.com/problems/merge-intervals/

//Time & Space Complexity: O(N) O(N)

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval == null) return intervals;
        if(intervals == null || intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        
        int start = newInterval.start;
        int end = newInterval.end;
        
        //case 1
        if(end < intervals.get(0).start){
            intervals.add(0, newInterval);
            return intervals;
        }
        
        //case 2
        if(start > intervals.get(intervals.size() - 1).end){
            intervals.add(newInterval);
            return intervals;
        }
        
        //rest
        for(int i=0; i<intervals.size(); i++){
            if(intervals.get(i).start >= start){
                intervals.add(i, newInterval);
                break;
            }
        }
        
        Stack<Interval> mergedIntervals = new Stack<>();
        mergedIntervals.push(intervals.get(0));
        
        for(int i=1; i<intervals.size(); i++){
            Interval prevInterval = mergedIntervals.pop();
            Interval currInterval = intervals.get(i);
            
            if(currInterval.start > prevInterval.end){
                mergedIntervals.push(prevInterval);
                mergedIntervals.push(currInterval);
            }else{
                int s = prevInterval.start;
                int e = Math.max(prevInterval.end, currInterval.end);
                Interval toAdd = new Interval(s, e);
                mergedIntervals.push(toAdd);
            }
        }
        
        ArrayList<Interval> ans = new ArrayList<>();
        for(Interval i : mergedIntervals){
            ans.add(i);
        }
        
        return ans;
    }
}
