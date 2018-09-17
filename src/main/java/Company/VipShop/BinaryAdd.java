package Company.VipShop;

import java.util.*;

/**
 * 二进制加法
 */
public class BinaryAdd {
    public static void revert(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        char[] num1 = split[0].toCharArray();
        char[] num2 = split[1].toCharArray();
        revert(num1);
        revert(num2);
        int sumLength = Math.max(num1.length, num2.length) + 1;
        int[] sum = new int[sumLength];
        for (int i = 0; i < sumLength; i++) {
            if (i < num1.length) {
                sum[i] += num1[i] - '0';
            }
            if (i < num2.length) {
                sum[i] += num2[i] - '0';
            }
        }
        for (int i = 0; i < sumLength - 1; i++) {
            if (sum[i] >= 2) {
                sum[i] -= 2;
                sum[i + 1]++;
            }
        }
        boolean flag = false;
        for (int i = sumLength - 1; i >= 0; i--) {
            if (sum[i] != 0) {
                flag = true;
            }
            if (flag) {
                System.out.print(sum[i]);
            }
        }
    }
}
