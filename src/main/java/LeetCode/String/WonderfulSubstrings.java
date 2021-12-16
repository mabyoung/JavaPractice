package LeetCode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        char[] chars = word.toCharArray();
        int n = word.length();
        int[] sum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int code = 1 << (chars[i] - 'a');
            sum[i + 1] = sum[i] ^ code;
            if (map.containsKey(sum[i + 1])) {
                result += map.get(sum[i + 1]);
            }
            for (int j = 0; j < 10; j++) {
                int target = sum[i + 1] ^ (1 << j);
                if (map.containsKey(target)) {
                    result += map.get(target);
                }
            }
            map.merge(sum[i + 1], 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        WonderfulSubstrings wonderfulSubstrings = new WonderfulSubstrings();
        long begin = System.currentTimeMillis();
        long result = wonderfulSubstrings.wonderfulSubstrings("aba");
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - begin);
    }
}
