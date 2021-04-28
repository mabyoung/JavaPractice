package LeetCode.Array;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 给出一组区间，请合并所有重叠的区间。
 * 例如，
 * 给出[1,3],[2,6],[8,10],[15,18],
 * 返回[1,6],[8,10],[15,18].
 */
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

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(3, 6));
        list.add(new Interval(8, 10));
        ArrayList<Interval> result = mergeIntervals.merge(list);
        for (Interval interval : result) {
            System.out.println(interval.start + "," + interval.end);
        }
    }
}
