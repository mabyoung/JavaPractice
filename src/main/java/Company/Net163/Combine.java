package Company.Net163;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/8.
 */
public class Combine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String[] split = scanner.nextLine().trim().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            char[] chars = split[2].toCharArray();
            for (int i = 0; i < chars.length; i++) {
                long numA = getNum(chars, 0, i, a);
                if (numA == getNum(chars, i + 1, chars.length - 1, b)) {
                    System.out.println(numA);
                    break;
                }
            }
        }
    }

    public static long getNum(char[] chars, int start, int end, int system) {
        long sum = 0;
        long bias = 1;
        for (int i = end; i >= start; i--) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                sum += (chars[i] - '0') * bias;
                bias *= system;
            } else if (chars[i] >= 'A' && chars[i] <= 'F') {
                sum += (chars[i] - 'A'+10) * bias;
                bias *= system;
            }
        }
        return sum;
    }
}
