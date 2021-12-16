package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class Merge {
    public class Interval {
        int left;
        int right;
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int[] item : intervals) {
            Interval interval = new Interval();
            interval.left = item[0];
            interval.right = item[1];
            list.add(interval);
        }
        list.sort((o1, o2) -> {
            if (o1.left == o2.left) {
                return o1.right - o2.right;
            } else {
                return o1.left - o2.left;
            }
        });
        List<Interval> resultList = new ArrayList<>();
        Interval last = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).left <= last.right) {
                last.right = Math.max(last.right, list.get(i).right);
            } else {
                Interval tmp = new Interval();
                tmp.left = last.left;
                tmp.right = last.right;
                resultList.add(tmp);
                last = list.get(i);
            }
        }
        resultList.add(last);
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i][0] = resultList.get(i).left;
            result[i][1] = resultList.get(i).right;
        }
        return result;
    }
}
