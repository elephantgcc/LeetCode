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
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (newInterval == null) {
            return result;
        } else if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        int startIndex = intervals.size();
        for(int i = 0; i < intervals.size(); ++i) {
            if (newInterval.start > intervals.get(i).end) {
                continue;
            } else if (newInterval.start >= intervals.get(i).start
                    && newInterval.start <= intervals.get(i).end) {
                startIndex = i;
                newInterval.start = intervals.get(i).start;
                break;
            } else {
                startIndex = i;
                break;
            }
        }
        if (startIndex == intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        }
        
        int endIndex = -1;
        int j = 0;
        for (; j < intervals.size(); ++j) {
            if (newInterval.end > intervals.get(j).end) {
                continue;
            } else if (newInterval.end >= intervals.get(j).start
                    && newInterval.end <= intervals.get(j).end) {
                endIndex = j;
                newInterval.end = intervals.get(j).end;
                break;
            } else {
                endIndex = j - 1;
                break;
            }
        }
        if (j == intervals.size()) {
            endIndex = j - 1;
        }
        if (endIndex == -1) {
            intervals.add(0, newInterval);
            return intervals;
        }
        
        for (int i = 0; i < startIndex; ++i) {
            result.add(intervals.get(i));
        }
        result.add(newInterval);
        for (int i = endIndex + 1; i < intervals.size(); ++i) {
            result.add(intervals.get(i));
        }
        
        return result;
    }
}
