package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for (int digit : digits) {
            list.add(digit);
        }
        int index = list.size() - 1;
        int carry = 1;
        while (index >= 0) {
            if (carry == 0) {
                break;
            }
            int value = list.get(index) + carry;
            if (value >= 10) {
                value -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            list.set(index, value);
            index--;
        }
        if (carry > 0) {
            list.add(0, carry);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
