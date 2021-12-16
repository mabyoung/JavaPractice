package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    Map<Integer, List<Integer>> coMap = new HashMap<>();
    Map<String, Integer> poMap = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        List<Integer> value = coMap.get(x);
        if (value == null) {
            List<Integer> list = new ArrayList<>();
            list.add(y);
            coMap.put(x, list);
        } else {
            value.add(y);
        }
        String key = x + "_" + y;
        poMap.merge(key, 1, Integer::sum);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        List<Integer> value = coMap.get(x);
        if (value == null) {
            return 0;
        }
        int result = 0;
        for (Integer item : value) {
            result += count(x, y, item);
        }
        return result;
    }

    public int count(int x, int y1, int y2) {
        if (y1 == y2) {
            return 0;
        }
        int result = 0;
        int abs = Math.abs(y1 - y2);
        String key1 = (x + abs) + "_" + y1;
        String key2 = (x + abs) + "_" + y2;
        Integer value1 = poMap.get(key1);
        Integer value2 = poMap.get(key2);
        if (value1 == null) {
            value1 = 0;
        }
        if (value2 == null) {
            value2 = 0;
        }
        result += value1 * value2;
        String key3 = (x - abs) + "_" + y1;
        String key4 = (x - abs) + "_" + y2;
        Integer value3 = poMap.get(key3);
        Integer value4 = poMap.get(key4);
        if (value3 == null) {
            value3 = 0;
        }
        if (value4 == null) {
            value4 = 0;
        }
        result += value3 * value4;
        return result;
    }
}
