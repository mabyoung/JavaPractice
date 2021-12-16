package LeetCode.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int[] pair : pairs) {
            pairMap.put(pair[0], pair[1]);
            pairMap.put(pair[1], pair[0]);
        }
        Map<String, Integer> preferenceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                preferenceMap.put(i + "_" + preferences[i][j], n - j);
            }
        }
        Set<Integer> unhappySet = new HashSet<>();
        for (int x = 0; x < n; x++) {
            if (unhappySet.contains(x)) {
                continue;
            }
            int y = pairMap.get(x);
            int pairIndex = findIndex(preferences[x], y);
            for (int j = pairIndex - 1; j >= 0; j--) {
                int u = preferences[x][j];
                int v = pairMap.get(u);
                if (preferenceMap.get(u + "_" + x) > preferenceMap.get(u + "_" + v)) {
                    unhappySet.add(x);
                    unhappySet.add(u);
                }
            }
        }
        return unhappySet.size();
    }

    public int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        UnhappyFriends unhappyFriends = new UnhappyFriends();
        int result = unhappyFriends.unhappyFriends(4, new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][]{{0, 1}, {2, 3}});
        System.out.println(result);
    }
}
