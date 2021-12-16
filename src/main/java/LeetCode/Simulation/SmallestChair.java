package LeetCode.Simulation;

import java.util.*;

public class SmallestChair {
    public int smallestChair(int[][] times, int targetFriend) {
        Map<Integer, Integer> arriveMap = new HashMap<>();
        Map<Integer, Set<Integer>> leaveMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            arriveMap.put(times[i][0], i);
            leaveMap.computeIfAbsent(times[i][1], k -> new HashSet<>());
            leaveMap.get(times[i][1]).add(i);
        }
        Map<Integer, Integer> siteMap = new HashMap<>();
        int[] table = new int[10000];
        Arrays.fill(table, -1);
        for (int i = 1; i < 100000; i++) {
            Set<Integer> leaveSet = leaveMap.get(i);
            if (leaveSet != null){
                for (Integer item : leaveSet) {
                    table[siteMap.get(item)] = -1;
                }
            }
            Integer arriveValue = arriveMap.get(i);
            if (arriveValue != null) {
                for (int j = 0; j < 10000; j++) {
                    if (table[j] == -1) {
                        if (arriveValue == targetFriend) {
                            return j;
                        }
                        table[j] = arriveValue;
                        siteMap.put(arriveValue, j);
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestChair smallestChair = new SmallestChair();
        int result = smallestChair.smallestChair(new int[][]{{4,5},{12,13},{5,6},{1,2},{8,9},{9,10},{6,7},{3,4},{7,8},{13,14},{15,16},{14,15},{10,11},{11,12},{2,3},{16,17}
        }, 15);
        System.out.println(result);
    }
}
