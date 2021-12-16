package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (time == 0) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < security.length; i++) {
                result.add(i);
            }
            return result;
        }
        int count = 1;
        int lastNum = security[0];
        int n = security.length;
        boolean[] flag1 = new boolean[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i] <= lastNum) {
                if (count >= time) {
                    flag1[i] = true;
                }
                count++;
            } else {
                count = 1;
            }
            lastNum = security[i];
        }
        count = 1;
        lastNum = security[n - 1];
        boolean[] flag2 = new boolean[security.length];
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= lastNum) {
                if (count >= time) {
                    flag2[i] = true;
                }
                count++;
            } else {
                count = 1;
            }
            lastNum = security[i];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (flag1[i] && flag2[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
