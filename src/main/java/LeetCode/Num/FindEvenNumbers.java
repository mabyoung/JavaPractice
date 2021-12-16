package LeetCode.Num;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k && digits[i] != 0 && digits[k] % 2 == 0) {
                        set.add(Integer.valueOf(digits[i] + "" + digits[j] + "" + digits[k]));
                    }
                }
            }
        }
        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
