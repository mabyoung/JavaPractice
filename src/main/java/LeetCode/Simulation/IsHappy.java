package LeetCode.Simulation;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int now = n;
        while (now != 1) {
            if (set.contains(now)) {
                return false;
            }
            set.add(now);
            now = getNext(now);
        }
        return true;
    }

    public int getNext(int num) {
        int result = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            int item = c - '0';
            result += item * item;
        }
        return result;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        boolean result = isHappy.isHappy(19);
        System.out.println(result);
    }
}
