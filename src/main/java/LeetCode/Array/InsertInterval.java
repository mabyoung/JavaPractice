package LeetCode.Array;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].
 * <p>
 * Example 2:
 * Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].
 */
public class InsertInterval {
    public static class Interval {
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

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int insertIndex = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start){
                result.add(interval);
                insertIndex++;
            } else if (interval.start > newInterval.end){
                result.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        result.add(insertIndex, newInterval);
        return result;
    }

    public ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0 && intervals.get(i).start > newInterval.end) {
                intervals.add(0, newInterval);
                return intervals;
            } else if (i == intervals.size() - 1 && intervals.get(i).end < newInterval.start) {
                intervals.add(i + 1, newInterval);
                return intervals;
            } else if (i > 0 && intervals.get(i - 1).end < newInterval.start && intervals.get(i).start > newInterval.end) {
                intervals.add(i, newInterval);
                return intervals;
            }
        }
        int start = newInterval.start, end = newInterval.end;
        for (int i = intervals.size() - 1; i >= 0; i--) {
            if (intervals.get(i).end >= newInterval.end && intervals.get(i).start <= newInterval.end) {
                start = Math.min(intervals.get(i).start, start);
                end = Math.max(intervals.get(i).end, end);
            }
            if (intervals.get(i).end >= newInterval.start && intervals.get(i).start <= newInterval.start) {
                start = Math.min(intervals.get(i).start, start);
                end = Math.max(intervals.get(i).end, end);
            }
        }
        boolean flag = true;
        for (Interval interval : intervals) {
            if (interval.end < start || interval.start > end) {
                result.add(interval);
            } else if (flag) {
                result.add(new Interval(start, end));
                flag = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(6, 8));
        Interval newInterval = new Interval(5, 6);
        ArrayList<Interval> result = insertInterval.insert(intervals, newInterval);
        for (Interval interval : result) {
            System.out.println(interval.start + "," + interval.end);
        }
    }
}
