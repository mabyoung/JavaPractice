package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {
    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            List<Integer> list = map.get(key);
            list.add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.get(value);
        if (list == null) {
            return 0;
        }
        int lessThan = getLessThan(list, right);
        int moreThan = getMoreThan(list, left);
        if (lessThan == -1 || moreThan == -1) {
            return 0;
        }
        return lessThan - moreThan + 1;
    }

    public int getMoreThan(List<Integer> list, int target) {
        if (list.get(list.size() - 1) < target) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getLessThan(List<Integer> list, int target) {
        if (list.get(0) > target) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3});
        System.out.println(rangeFreqQuery.query(6, 8, 4));
    }
}
