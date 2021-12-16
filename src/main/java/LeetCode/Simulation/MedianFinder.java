package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    List<Integer> list = new ArrayList<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        list.add(getIndex(num), num);
    }

    public double findMedian() {
        int mid = list.size() / 2;
        if (list.size() % 2 == 0) {
            return (list.get(mid) + list.get(mid - 1)) / 2.0;
        } else {
            return list.get(mid);
        }
    }

    public int getIndex(int num) {
        if (list.isEmpty() || num < list.get(0)) {
            return 0;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) == num) {
                return mid + 1;
            } else if (list.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left + 1;
    }
}
