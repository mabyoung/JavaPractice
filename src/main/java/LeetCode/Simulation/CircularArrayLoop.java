package LeetCode.Simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = (i + nums[i]) % nums.length;
            while (j < 0) {
                j += nums.length;
            }
            if (i == j) {
                continue;
            }
            if ((nums[i] > 0 && nums[j] > 0) || (nums[i] < 0 && nums[j] < 0)) {
                map.put(i, j);
            }
        }
        for (Integer key : map.keySet()) {
            if (bfs(map, key)) {
                return true;
            }
        }
        return false;
    }

    public boolean bfs(Map<Integer, Integer> map, int start) {
        Set<Integer> set = new HashSet<>();
        set.add(start);
        Integer next = map.get(start);
        while (next != null) {
            if (set.contains(next)) {
                return true;
            }
            set.add(next);
            next = map.get(next);
        }
        return false;
    }

    public static void main(String[] args) {
        CircularArrayLoop circularArrayLoop = new CircularArrayLoop();
        boolean result = circularArrayLoop.circularArrayLoop(new int[]{-2, -3, -9});
        System.out.println(result);
    }
}
