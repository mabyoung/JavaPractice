package LeetCode.Num;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        map.put(n, result);
        return result;
    }
}
