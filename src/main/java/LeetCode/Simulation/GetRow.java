package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
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
        return result.get(rowIndex);
    }
}
