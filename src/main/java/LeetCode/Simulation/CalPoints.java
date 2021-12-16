package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class CalPoints {
    public int calPoints(String[] ops) {
        List<String> opList = new ArrayList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                opList.remove(opList.size() - 1);
            } else {
                opList.add(op);
            }
        }
        List<Integer> pointList = new ArrayList<>();
        for (String op : opList) {
            if ("+".equals(op)) {
                pointList.add(pointList.get(pointList.size() - 1) + pointList.get(pointList.size() - 2));
            } else if ("D".equals(op)) {
                pointList.add(pointList.get(pointList.size() - 1) * 2);
            } else {
                pointList.add(Integer.parseInt(op));
            }
        }
        int result = 0;
        for (Integer point : pointList) {
            result += point;
        }
        return result;
    }
}
