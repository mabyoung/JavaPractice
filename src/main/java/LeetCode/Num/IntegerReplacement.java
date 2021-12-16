package LeetCode.Num;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    Map<Long, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return integerReplacement((long)n);
    }

    public int integerReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result;
        if (n % 2 == 0) {
            result = 1 + integerReplacement(n / 2);
        } else {
            result = 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
        }
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        IntegerReplacement integerReplacement = new IntegerReplacement();
        System.out.println(integerReplacement.integerReplacement(2147483647));
    }
}
