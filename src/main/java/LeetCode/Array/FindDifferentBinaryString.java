package LeetCode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDifferentBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("0");
        }
        String now = stringBuilder.toString();
        while (set.contains(now)) {
            now = getNext(now);
        }
        return now;
    }

    public String getNext(String str) {
        char[] chars = str.toCharArray();
        int index = chars.length - 1;
        while (index >= 0) {
            if (chars[index] == '0') {
                chars[index] = '1';
                break;
            } else {
                chars[index] = '0';
            }
            index--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        FindDifferentBinaryString findDifferentBinaryString = new FindDifferentBinaryString();
        String now = new String("00000");
        for (int i = 0; i < 100; i++) {
            System.out.println(now);
            now = findDifferentBinaryString.getNext(now);
        }

        System.out.println(findDifferentBinaryString.findDifferentBinaryString(new String[]{"01", "00"}));
    }
}
