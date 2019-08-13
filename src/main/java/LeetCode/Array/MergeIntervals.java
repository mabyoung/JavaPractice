package LeetCode.Array;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeIntervals {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        for (int i = 1; i < intervals.size(); i++) {
            Interval lastInterval = intervals.get(i - 1);
            Interval interval = intervals.get(i);
            if (interval.start <= lastInterval.end) {
                interval.start = lastInterval.start;
                interval.end = Math.max(interval.end, lastInterval.end);
                intervals.set(i - 1, null);
            }
        }
        while (intervals.remove(null)) ;
        return intervals;
    }

    public ArrayList<Interval> merge1(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));
        ArrayList<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval lastInterval = result.get(result.size() - 1);
            Interval interval = intervals.get(i);
            if (interval.start <= lastInterval.end) {
                lastInterval.start = Math.min(lastInterval.start, interval.start);
                lastInterval.end = Math.max(lastInterval.end, interval.end);
            } else {
                result.add(intervals.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(3, 6));
//        list.add(new Interval(8, 10));
        ArrayList<Interval> result = mergeIntervals.merge(list);
        for (Interval interval : result) {
            System.out.println(interval.start + "," + interval.end);
        }
    }
}
