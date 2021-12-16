package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
            } else {
                List<Integer> lastList = result.get(i - 1);
                list.add(1);
                for (int j = 1; j < lastList.size(); j++) {
                    list.add(lastList.get(j - 1) + lastList.get(j));
                }
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }
}
