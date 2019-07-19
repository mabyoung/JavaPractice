package LeetCode.Array;

import java.util.Arrays;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * 输入的数组digits表示一个大整数，每个表示一位
 */
public class PlusOne {
    public int[] plusOne(int[] digits){
        boolean flag = true;
        int i = digits.length-1;
        while(i>=0){
            if (++digits[i] < 10){
                flag = false;
                break;
            }
            digits[i--] = 0;
        }
        if (flag){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int j = 1; j < result.length; j++) {
                result[j] = 0;
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(new int[]{9});
        System.out.println(Arrays.toString(result));
    }
}
