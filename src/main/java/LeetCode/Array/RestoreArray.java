package LeetCode.Array;

import LeetCode.Simulation.ReadBinaryWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreArray {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] result = new int[adjacentPairs.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.computeIfAbsent(adjacentPair[0], k -> new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.computeIfAbsent(adjacentPair[1], k -> new ArrayList<>());
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1){
                result[0] = entry.getKey();
                break;
            }
        }
        result[1] = map.get(result[0]).get(0);
        for (int i = 1; i < result.length - 1; i++) {
            List<Integer> list = map.get(result[i]);
            int next = list.get(0) != result[i - 1] ? list.get(0) : list.get(1);
            result[i + 1] = next;
        }
        return result;
    }

    public static void main(String[] args) {
        RestoreArray restoreArray = new RestoreArray();
        int[] result = restoreArray.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}});
        System.out.println(result);
    }
}
