package LeetCode.Num;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNum(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isSelfDividingNum(int num) {
        for (char c : String.valueOf(num).toCharArray()) {
            if (c == '0' || num % (c - '0') != 0) {
                return false;
            }
        }
        return true;
    }
}
