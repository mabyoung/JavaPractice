package LeetCode.Simulation;

import java.util.*;

public class NumWays {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] item : relation) {
            int key = item[0];
            Set<Integer> value = map.get(item[0]);
            if (value == null) {
                value = new HashSet<>();
                map.put(key, value);
            }
            value.add(item[1]);
        }
        List<Integer> myList = new ArrayList<>();
        myList.add(0);
        while (--k >= 0) {
            List<Integer> newList = new ArrayList<>();
            for (Integer item : myList) {
                if (map.get(item) != null){
                    newList.addAll(map.get(item));
                }
            }
            myList = newList;
        }
        int result = 0;
        for (Integer item : myList) {
            if (item == n - 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        int result = numWays.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3);
        System.out.println(result);
    }
}
