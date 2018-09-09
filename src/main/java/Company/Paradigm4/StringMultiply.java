package Company.Paradigm4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/9.
 */
public class StringMultiply {
    public static void revert(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] num1 = scanner.nextLine().trim().toCharArray();
        char[] num2 = scanner.nextLine().trim().toCharArray();
        revert(num1);
        revert(num2);
        int temp1;
        int[] result = new int[num1.length + num2.length];
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                result[i + j] += ((int) num1[i] - '0') * ((int) num2[j] - '0');
            }
        }
        for (int i = 0; i < num1.length + num2.length - 1; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        for (int i = 0; i < (num1.length + num2.length) / 2; i++) {
            temp1 = result[i];
            result[i] = result[num1.length + num2.length - 1 - i];
            result[num1.length + num2.length - 1 - i] = temp1;
        }
        int index = 0;
        for (; index < result.length; index++) {
            if (result[index] != 0) {
                break;
            }
        }
        for (; index < result.length; index++) {
            System.out.print(result[index]);
        }
    }
}
