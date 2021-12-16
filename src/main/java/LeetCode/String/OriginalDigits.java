package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class OriginalDigits {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int[] nums = new int[10];
        process(map, 'z', "zero", nums, 0);
        process(map, 'u', "four", nums, 4);
        process(map, 'g', "eight", nums, 8);
        process(map, 'f', "five", nums, 5);
        process(map, 'h', "three", nums, 3);
        process(map, 'x', "six", nums, 6);
        process(map, 'i', "nine", nums, 9);
        process(map, 't', "two", nums, 2);
        process(map, 's', "seven", nums, 7);
        process(map, 'o', "one", nums, 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }

    public void process(Map<Character, Integer> map, char c, String target, int[] nums, int index) {
        Integer value = map.get(c);
        if (value != null && value > 0) {
            nums[index] += value;
            minus(map, target, value);
        }
    }

    public void minus(Map<Character, Integer> map, String target, int count) {
        for (char c : target.toCharArray()) {
            Integer value = map.get(c);
            if (value > count) {
                map.put(c, value - count);
            } else {
                map.remove(c);
            }
        }
    }
}
